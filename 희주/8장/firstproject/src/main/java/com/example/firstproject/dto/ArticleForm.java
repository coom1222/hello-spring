package com.example.firstproject.dto;

import com.example.firstproject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString

public class ArticleForm {
    private String title;
    private String content;
    private Long id;



    public Article toEntity() {
        return new Article(id, title, content);
    }
}
