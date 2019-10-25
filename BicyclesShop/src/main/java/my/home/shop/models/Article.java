package my.home.shop.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import my.home.shop.models.enums.ArticleType;

import javax.persistence.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "articles")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;
    @Column(length = 128, unique = true)
    String name;
    Double price;
    @Enumerated(value = EnumType.STRING)
    private ArticleType type;
}
