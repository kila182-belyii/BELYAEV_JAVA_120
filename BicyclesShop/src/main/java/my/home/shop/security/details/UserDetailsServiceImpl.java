package my.home.shop.security.details;

import my.home.shop.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import my.home.shop.repositories.UsersRepository;

import java.util.Optional;

@Service(value = "customUserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Optional<User> userCandidate = usersRepository.findByLogin(login);
        if (userCandidate.isPresent()) {
            User user = userCandidate.get();
            return new UserDetailsImpl(user);
        }
        throw new UsernameNotFoundException("User with login " + login + " not found");
    }
}
