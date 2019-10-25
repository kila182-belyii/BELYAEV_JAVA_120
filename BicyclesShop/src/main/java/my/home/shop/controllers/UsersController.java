package my.home.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import my.home.shop.dto.CartDto;
import my.home.shop.dto.UserDto;
import my.home.shop.security.details.UserDetailsImpl;
import my.home.shop.services.CartService;
import my.home.shop.services.UsersService;
import my.home.shop.utils.UserAuthenticationUtil;

import java.util.List;

@Controller
public class UsersController {
    @Autowired
    private UsersService usersService;

    @Autowired
    private CartService cartService;

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @GetMapping(value = "/users")
    public String getUsersPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        List<UserDto> users = usersService.getAllUsers();
        model.addAttribute("users", users);
        model.addAttribute("user", authenticationUtil.getUserByUserDetails(user));
        return "users";
    }

    @GetMapping(value = "/users/carts")
    public String getUsersCartsPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", authenticationUtil.getUserByUserDetails(user));
        List<CartDto> cartDtos = cartService.getAllCarts();
        model.addAttribute("cartDtos", cartDtos);
        return "usersCarts";
    }
}