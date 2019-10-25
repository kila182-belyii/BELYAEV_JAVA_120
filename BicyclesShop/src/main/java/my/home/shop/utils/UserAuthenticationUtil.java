package my.home.shop.utils;

import org.springframework.stereotype.Component;
import my.home.shop.dto.UserDto;
import my.home.shop.models.User;
import my.home.shop.security.details.UserDetailsImpl;

import static my.home.shop.dto.UserDto.from;

@Component
public class UserAuthenticationUtil {
    public UserDto getUserByUserDetails(UserDetailsImpl userDetails) {
        User user = userDetails.getUser();
        return from(user);
    }
}
