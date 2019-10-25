package my.home.shop.services;

import my.home.shop.dto.CartArticleDto;
import my.home.shop.dto.CartDto;

import java.util.List;

public interface CartService {
    Long getCartIdByUserId(Long userId);
    void addArticleToCart(Long cartId, Long articleId);
    void deleteArticleFromCart(Long cartId, Long articleId);
    List<CartArticleDto> getArticlesByCartId(Long cartId);
    List<CartDto> getAllCarts();
}
