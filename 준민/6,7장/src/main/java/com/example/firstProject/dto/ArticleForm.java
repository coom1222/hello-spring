package com.example.firstProject.dto;

import com.example.firstProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // ArticleForm에 생성자를 추가 이 어노테이션은 클래스 안쪽의 모든 필드, 즉 title과 content를 매개변수로 하는 생성자가 자동으로 생성된다.
@ToString           // toString() 메서드를 를 실행하는 것과 같은 효과이다.

public class ArticleForm {

    private final String title;
    private final String content;


    public Article toEntity() {
        return new Article(null, title, content);   // Article 엔티티의 생성자 입력 양식에 맞게
    }
}

