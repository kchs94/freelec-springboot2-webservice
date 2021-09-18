package com.jojoldu.book.springboot.domain.posts;

import com.jojoldu.book.springboot.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter // 클래스 내 모든 필드의 Getter 메소드 자동 생성
@NoArgsConstructor // 기본 생성자 자동 추가. public Posts(){}와 같은 효과
@Entity // 테이블과 링크될 클래스임을 나타낸다.
public class Posts extends BaseTimeEntity { // 등록

    @Id // 해당 테이블의 PK 필드를 나타냅니다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // PK 생성 규칙을 나타냅니다.
    private Long id; // 아이디

    @Column(length = 500, nullable = false) // 테이블의 칼럼을 의마하며 굳이 선언안해도 해당 클래스의 필드는 모두 칼럼이 된다.
    private String title; // 제목, 사용하는 이유는 기본값 외에 추가로 변경이 필요한 옵션이 있으면 사용한다. 문자열의 경우 VARCHAR(255)가 기본값인데 사이즈를 500으로 늘리거나 타입을 TEXT로 변경하고 싶거나 등일 때 사용

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content; // 내용

    private String author; // 글쓴이

    @Builder    // 해당 클래스의 빌더 패턴 클래스를 생성. 생섯ㅇ자 상단에 선언 시 생성자에 포함된 필드만 빌더에 포함.
    public Posts(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}