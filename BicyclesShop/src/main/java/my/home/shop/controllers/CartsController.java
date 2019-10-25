package my.home.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import my.home.shop.dto.CartArticleDto;
import my.home.shop.dto.UserDto;
import my.home.shop.security.details.UserDetailsImpl;
import my.home.shop.services.CartService;
import my.home.shop.utils.UserAuthenticationUtil;

import java.util.List;

@Controller
public class CartsController {
    @Autowired
    private CartService cartService;

    @Autowired
    private UserAuthenticationUtil authenticationUtil;

    @GetMapping(value = "/cart")
    public String getArticlesPage(Model model, @AuthenticationPrincipal UserDetailsImpl userDetails) {
        UserDto user = authenticationUtil.getUserByUserDetails(userDetails);
        Long cartId = cartService.getCartIdByUserId(user.getId());
        model.addAttribute("user", user);
        model.addAttribute("cartId", cartId);
        List<CartArticleDto> articles = cartService.getArticlesByCartId(cartId);
        model.addAttribute("articles", articles);

        return "cart";
    }

    @PostMapping(value = "/cart",
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public void addArticleToCart(@RequestBody CartArticleDto form) {
        cartService.addArticleToCart(form.getCartId(), form.getArticleId());
    }

    @PostMapping(value = "/cart/delete", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @ResponseBody
    public List<CartArticleDto> deleteArticleFromCart(@RequestBody CartArticleDto form) {
        cartService.deleteArticleFromCart(form.getCartId(), form.getArticleId());
        return cartService.getArticlesByCartId(form.getCartId());
    }
}
