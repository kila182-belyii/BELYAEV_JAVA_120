package my.home.shop.forms;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.home.shop.models.enums.ArticleType;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ArticleForm {
    private String name;
    private Double price;
    private ArticleType type;
}
