package com.example.firstProject.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor // Article() 생성자 추가, 이 어노테이션은 기본 생성자를 자동으로 생성한다.
@AllArgsConstructor // Article() 생성자 대체 어노테이션
@ToString         // toString() 메서드 대체 어노테이션
@Entity                     // 엔티티 클래스임을 명시, 이 어노테이션이 붙은 클래스를 기반으로 DB 테이블이 생성됨
public class Article {
    @Getter
    @Id                     // 엔티티의 대푯값 지정
    @GeneratedValue         // 자동 생성기능 추가(숫자가 자동으로 매겨짐)

    private Long id;

    @Column                 // title 필드 선언, DB 테이블의 title 열과 연결
    private String title;

    @Column                 // content 필드 선언, DB 테이블의 content 열과 연결
    private String content;


}
