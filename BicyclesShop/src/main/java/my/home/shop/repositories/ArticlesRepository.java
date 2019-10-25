package my.home.shop.repositories;

import my.home.shop.models.enums.ArticleType;
import org.springframework.data.jpa.repository.JpaRepository;
import my.home.shop.models.Article;

import java.util.List;

public interface ArticlesRepository extends JpaRepository<Article, Long> {
    List<Article> findAllByType(ArticleType type);
}
