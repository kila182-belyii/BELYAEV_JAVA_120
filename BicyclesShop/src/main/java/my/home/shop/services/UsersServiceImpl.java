package my.home.shop.services;

import freemarker.template.Template;
import lombok.SneakyThrows;
import my.home.shop.models.Cart;
import my.home.shop.models.enums.UserRole;
import my.home.shop.models.enums.UserState;
import my.home.shop.repositories.CartsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import my.home.shop.forms.SignUpForm;
import my.home.shop.dto.UserDto;
import my.home.shop.models.User;
import my.home.shop.repositories.UsersRepository;

import java.io.StringWriter;
import java.util.*;
import java.util.concurrent.ExecutorService;

import static my.home.shop.dto.UserDto.from;

@Component
public class UsersServiceImpl implements UsersService {

    private Logger logger = LoggerFactory.getLogger(UsersServiceImpl.class);

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private EmailService emailService;

    @Value("${mail.confirm.subject}")
    private String subject;

    @Value("${server.url}")
    private String serverUrl;

    @Autowired
    private Template confirmMailTemplate;

    @Autowired
    private ExecutorService executorService;

    @Autowired
    private CartsRepository cartsRepository;

    @Transactional
    @Override
    public void signUp(String uuid, SignUpForm form) {

        User user = usersRepository.findByConfirmUUID(uuid);

        user.setHashPassword(passwordEncoder.encode(form.getPassword()));
        user.setLogin(form.getLogin());
        user.setRole(UserRole.USER);
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setState(UserState.CONFIRMED);
        user.setConfirmUUID(null);

        usersRepository.save(user);
        Cart cart = Cart.builder().user(user).build();
        cartsRepository.save(cart);
        }

    @Transactional
    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = usersRepository.findAll();
        return from(users);
    }

    @SneakyThrows
    @Override
    public void emailConfirm(String email) {

        Optional<User> user = usersRepository.findByEmail(email);

        User newUser = user.orElseGet(() -> User.builder()
                .email(email)
                .build());

        newUser.setState(UserState.NOT_CONFIRMED);
        newUser.setConfirmUUID(UUID.randomUUID().toString());

        usersRepository.save(newUser);

        Runnable confirmMailTask = () -> {
            Map<String, Object> placeholders = new HashMap<>();
            placeholders.put("host", serverUrl);
            placeholders.put("id", newUser.getConfirmUUID());

            StringWriter stringWriter = new StringWriter();
            try {
                confirmMailTemplate.process(placeholders, stringWriter);

            } catch (Exception e) {
                throw new IllegalArgumentException(e);
            }
            String mailText = stringWriter.toString();

            logger.info("Send email to " + newUser.getEmail() + " by thread " + Thread.currentThread().getName());
            emailService.sendEmail(newUser.getEmail(), subject, mailText);

        };

        executorService.submit(confirmMailTask);
    }

    @Override
    public boolean isNotValidUUID(String uuid) {
        return !usersRepository.existsByConfirmUUID(uuid);
    }
}
