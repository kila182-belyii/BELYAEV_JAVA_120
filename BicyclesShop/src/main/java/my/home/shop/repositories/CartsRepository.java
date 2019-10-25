package my.home.shop.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import my.home.shop.models.Cart;

import java.util.Optional;

public interface CartsRepository extends JpaRepository<Cart, Long> {
    Optional<Cart> findByUser_Id(Long userId);
}
