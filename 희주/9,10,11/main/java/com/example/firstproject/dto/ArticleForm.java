package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Getter

public class ArticleForm {
    private String title;
    private String content;
    private Long id;



    public Article toEntity() {
        return new Article(id, title, content);
    }
}
