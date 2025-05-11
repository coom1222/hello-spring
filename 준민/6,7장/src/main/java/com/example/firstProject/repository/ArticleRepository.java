package com.example.firstProject.repository;

import com.example.firstProject.entity.Article;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface ArticleRepository extends CrudRepository<Article, Long> {
    @Override
    ArrayList<Article> findAll();   // Iterable -> ArrayList로 오버라이딩, 재정의

}
