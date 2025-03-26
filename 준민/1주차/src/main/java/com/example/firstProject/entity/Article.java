package com.example.firstProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
@Entity                     // 엔티티 클래스임을 명시
public class Article {
    @Id                     // 엔티티의 대푯값 지정
    @GeneratedValue         // 자동 생성기능 추가(숫자가 자동으로 매겨짐)
    private Long id;

    @Column                 // title 필드 선언, DB 테이블의 title 열과 연결
    private String title;

    @Column                 // content 필드 선언, DB 테이블의 content 열과 연결
    private String content;

 /*   public Article(Long id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                '}';
    }*/
}
