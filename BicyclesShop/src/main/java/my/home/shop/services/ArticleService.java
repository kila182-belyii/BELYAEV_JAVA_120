package my.home.shop.services;

import my.home.shop.dto.ArticleDto;
import my.home.shop.forms.ArticleForm;
import my.home.shop.models.Article;

import java.util.List;

public interface ArticleService {
    Article addArticle(ArticleForm form);
    List<ArticleDto> getAllArticles();
    List<ArticleDto> getAllBicycles();
    List<ArticleDto> getAllParts();
    List<ArticleDto> getAllAccessories();
    void delete(Long article_id);
}
