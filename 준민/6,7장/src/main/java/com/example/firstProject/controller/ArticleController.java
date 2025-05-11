package com.example.firstProject.controller;

import com.example.firstProject.dto.ArticleForm;
import com.example.firstProject.entity.Article;
import com.example.firstProject.entity.Member;
import com.example.firstProject.repository.ArticleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Slf4j                                  // 로깅 기능을 위한 어노테이션 추가
@Controller
public class ArticleController {
    @Autowired  // 리파지토리 객체를 자동으로 주입받기 위한 어노테이션
    private ArticleRepository articleRepository;


    @GetMapping("/articles/new")
    public String newArticleForm() {
        return "articles/new";
    }


    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        log.info(form.toString());
        Article article = form.toEntity();  // DTO를 엔티티로 변환.
        log.info(form.toString());  // 로깅 코드 추가

        Article saved = articleRepository.save(article); // 리파지토리로 article 엔티티를 DB에 저장, saved객체에 반환.
        // saved 객체는 articleRepository에 CRUDRepository안에 내장 라이브러리
        log.info(saved.toString());  // 로깅 코드 추가
        return "redirect:/articles/" + saved.getId();  // redirect를 통해 저장된 article의 id로 이동
    }


    @GetMapping("/articles/{id}")  // 데이터 조회 요청 접수
    public String show(@PathVariable Long id, Model model){  // 매개변수 id로 받아오기
        log.info("id: " + id);  // id를 잘 받았는지 로깅 코드 추가
        // 1. id를 조회해 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);  // id로 데이터 조회
        // 2. 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);  // Name이라는 이름으로 value 객체 추가, article등록을 뷰 페이지에서 사용
        // 3. 뷰 페이지 반환하기
        return "articles/show";
    }


    @GetMapping("/articles")  // 데이터 목록 요청 접수
    public String index(Model model){
        // 1. 모든 데이터 가져오기
        List<Article> articleEntityList = articleRepository.findAll();
        // 2. 모델에 데이터 등록하기
        model.addAttribute("articleList", articleEntityList);
        // 3. 뷰 페이지 반환하기
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){  // id를 매개변수로 받아오기
        // 수정할 데이터 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);    // DB에서 수정할 데이터 가져오기
        // 모델에 데이터 등록하기
        model.addAttribute("article", articleEntity);  // articleEntity를 article이라는 이름으로 모델에 등록
        //뷰 페이지 설정하기
        return "articles/edit";
    }


}
