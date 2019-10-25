package my.home.shop.controllers;

import my.home.shop.dto.UserDto;
import my.home.shop.security.details.UserDetailsImpl;
import my.home.shop.utils.UserAuthenticationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class NotFoundController {

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @GetMapping(value = "/404")
    public String getNotFoundPage(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        model.addAttribute("user", user);
        return "404";
    }
}