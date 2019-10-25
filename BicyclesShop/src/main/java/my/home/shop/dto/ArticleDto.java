package my.home.shop.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.home.shop.models.Article;
import my.home.shop.models.enums.ArticleType;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDto {
    private Long id;
    private String name;
    private Double price;
    private ArticleType type;

    public static ArticleDto from(Article model) {
        return ArticleDto.builder()
                .id(model.getId())
                .name(model.getName())
                .price(model.getPrice())
                .type(model.getType())
                .build();
    }

    public static List<ArticleDto> from(List<Article> models) {
        return models.stream()
                .map(ArticleDto::from)
                .collect(Collectors.toList());
    }
}
