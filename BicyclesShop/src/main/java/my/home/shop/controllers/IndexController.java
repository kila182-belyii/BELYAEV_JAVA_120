package my.home.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import my.home.shop.security.details.UserDetailsImpl;
import my.home.shop.utils.UserAuthenticationUtil;

@Controller
public class IndexController {

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @GetMapping(value = "/index")
    public String getIndexPage(@AuthenticationPrincipal UserDetailsImpl user, Model model) {
        model.addAttribute("user", authenticationUtil.getUserByUserDetails(user));
        return "index";
    }
}
