package my.home.shop.services;

import my.home.shop.forms.SignUpForm;
import my.home.shop.dto.UserDto;

import java.util.List;

public interface UsersService {
    void signUp(String uuid, SignUpForm form);
    List<UserDto> getAllUsers();

    void emailConfirm(String email);

    boolean isNotValidUUID(String uuid);
}
