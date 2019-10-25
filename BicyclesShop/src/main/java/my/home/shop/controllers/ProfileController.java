package my.home.shop.controllers;

import my.home.shop.security.details.UserDetailsImpl;
import my.home.shop.utils.UserAuthenticationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProfileController {

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @GetMapping(value = "/profile")
    public String getProfilePage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", authenticationUtil.getUserByUserDetails(user));
        return "profile";
    }
}
