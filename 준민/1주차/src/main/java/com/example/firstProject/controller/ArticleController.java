package com.example.firstProject.controller;

import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.entity.Article;
import com.example.firstProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j                                  // 로깅 기능을 위한 어노테이션 추가
@Controller
public class ArticleController {
    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        // System.out.println(form.toString());    // DTO에 폼 데이터가 잘 담겼는지.
        log.info(form.toString());

        //1. DTO를 엔티티로 변환
        Article article = form.toEntity();
        // System.out.println("생성된 article entity: " + article.toString());
        log.info(article.toString());

        //2. 리파지토리로 엔티티를 DB에 저장
        Article saved = articleRepository.save(article);
        // System.out.println("저장된 Article 엔티티: " +saved.toString());
        log.info(saved.toString());
        return "articles/new";
    }

}
