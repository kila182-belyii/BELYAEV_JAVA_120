package my.home.shop.controllers;

import my.home.shop.dto.ArticleDto;
import my.home.shop.dto.UserDto;
import my.home.shop.forms.ArticleForm;
import my.home.shop.models.Article;
import my.home.shop.security.details.UserDetailsImpl;
import my.home.shop.services.ArticleService;
import my.home.shop.services.CartService;
import my.home.shop.utils.UserAuthenticationUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class PartsController {
    @Autowired
    private ArticleService articleService;

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @Autowired
    private CartService cartService;

    @GetMapping(value = "/parts")
    public String getArticlesPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        List<ArticleDto> articles = articleService.getAllParts();
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        model.addAttribute("articles", articles);
        model.addAttribute("user", user);
        user.setCartId(cartService.getCartIdByUserId(user.getId()));
        return "parts";
    }
    @PostMapping(value = "/parts/add",
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public ArticleDto addArticlesPage(@RequestBody ArticleForm form) {
        Article article = articleService.addArticle(form);
        return ArticleDto.from(article);
    }

    @GetMapping(value = "/parts/add")
    public String addArticlesPageGet(@AuthenticationPrincipal UserDetailsImpl userDetails, Model model) {
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        model.addAttribute("user", user);
        return "partsAdd";
    }
}