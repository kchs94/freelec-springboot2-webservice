package com.jojoldu.book.springboot.domain.posts;
// JpaRepository: DB Layer 접근자. 인터페이스로 생성한다.JpaRepositry<Entity 클래스, PK타입>을 상속하면 기본적인
// CRUD 메소드가 자동으로 만들어진다.
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface PostsRepository extends JpaRepository<Posts, Long> {

    @Query("SELECT p FROM Posts p ORDER BY p.id DESC")
    List<Posts> findAllDesc();
}
