package com.example.firstProject.dto;

import com.example.firstProject.entity.Article;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor // ArticleForm에 생성자를 추가 이 어노테이션은 클래스 안쪽의 모든 필드, 즉 title과 content를 매개변수로 하는 생성자가 자동으로 생성된다.
@ToString           // toString() 메서드를 를 실행하는 것과 같은 효과이다.
public class ArticleForm {
    private String title;   // 제목을 받을 필드
    private String content; // 내용을 받을 필드
/*
    public ArticleForm(String title, String content) {
        this.title = title;
        this.content = content;
    }
*/

    // ArticleForm을 Article 엔티티로 변환하는 메서드 추가
    public Article toEntity() {
        return new Article(null, title, content);
    }

   /* // 데이터를 잘 받았는지 확인할 toString() 메서드 추가
    @Override
    public String toString() {
        return "ArticleForm{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }*/


}
