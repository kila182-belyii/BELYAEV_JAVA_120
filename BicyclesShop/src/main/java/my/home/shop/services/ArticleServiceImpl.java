package my.home.shop.services;

import my.home.shop.forms.ArticleForm;
import my.home.shop.models.enums.ArticleType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import my.home.shop.dto.ArticleDto;
import my.home.shop.models.Article;
import my.home.shop.repositories.ArticlesRepository;

import java.util.List;

import static my.home.shop.dto.ArticleDto.from;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    ArticlesRepository articlesRepository;

    @Override
    public List<ArticleDto> getAllArticles() {
        List<Article> articles = articlesRepository.findAll();
        return from(articles);
    }

    @Override
    public List<ArticleDto> getAllBicycles() {
        List<Article> articles = articlesRepository.findAllByType(ArticleType.BICYCLE);
        return from(articles);
    }

    @Override
    public List<ArticleDto> getAllParts() {
        List<Article> articles = articlesRepository.findAllByType(ArticleType.PART);
        return from(articles);
    }

    @Override
    public List<ArticleDto> getAllAccessories() {
        List<Article> articles = articlesRepository.findAllByType(ArticleType.ACCESSORY);
        return from(articles);
    }

    @Override
    @Transactional
    public Article addArticle(ArticleForm form) {
        Article article = Article.builder()
                .name(form.getName())
                .price(form.getPrice())
                .type(form.getType())
                .build();
        articlesRepository.save(article);
        return article;
    }

    @Override
    public void delete(Long article_id) {
        articlesRepository.deleteById(article_id);
    }
}
