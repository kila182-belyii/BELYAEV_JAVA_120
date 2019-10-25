package my.home.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import my.home.shop.dto.ArticleDto;
import my.home.shop.dto.CartArticleDto;
import my.home.shop.dto.CartDto;
import my.home.shop.dto.UserDto;
import my.home.shop.models.Article;
import my.home.shop.models.Cart;
import my.home.shop.models.User;
import my.home.shop.repositories.CartsRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class CartServiceImpl implements CartService {

    @Autowired
    private CartsRepository cartsRepository;

    @Override
    public Long getCartIdByUserId(Long userId) {
        Optional<Cart> cartCandidate = cartsRepository.findByUser_Id(userId);
        return cartCandidate.get().getId();
    }

    @Override
    public void deleteArticleFromCart(Long cartId, Long articleId) {
        Cart cart = cartsRepository.getOne(cartId);
        cart.getArticles().removeIf(article -> article.getId().equals(articleId));
        cartsRepository.save(cart);
    }

    @Override
    public void addArticleToCart(Long userId, Long articleId) {
        Optional <Cart> cartCandidate = cartsRepository.findByUser_Id(userId);
        Cart cart = cartCandidate.get();
        cart.getArticles().add(Article.builder().Id(articleId).build());
        cartsRepository.save(cart);
    }

    @Override
    public List<CartDto> getAllCarts() {
        List<Cart> carts = cartsRepository.findAll();
        List<CartDto> result = new ArrayList<>();
        for (Cart cart : carts) {
            User user = cart.getUser();
            CartDto cartDto = CartDto.builder()
                    .id(cart.getId())
                    .user(UserDto.from(user))
                    .build();
            List<ArticleDto> articleDtos = new ArrayList<>();
            for(Article article : cart.getArticles()) {
                articleDtos.add(ArticleDto.from(article));
            }
            cartDto.setArticles(articleDtos);
            result.add(cartDto);
        }
        return result;
    }

    @Override
    public List<CartArticleDto> getArticlesByCartId(Long cartId) {

        List<Article> articles = cartsRepository.getOne(cartId).getArticles();

        List<CartArticleDto> result = new ArrayList<>();

        for (Article article : articles) {
            CartArticleDto cartArticleDto = CartArticleDto.builder()
                    .articleId(article.getId())
                    .name(article.getName())
                    .price(article.getPrice())
                    .cartId(cartId)
                    .build();
            result.add(cartArticleDto);
        }
        return result;

    }
}
