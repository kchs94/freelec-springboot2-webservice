package com.jojoldu.book.springboot.domain;

import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;
import java.time.LocalDateTime;

@Getter
@MappedSuperclass   // JPA Entiti 클래스들이 BaseTimeEntity를 상속할 경우 필드들도 칼럼으로 인식하도록 해준다.
@EntityListeners(AuditingEntityListener.class) // BaseTimeEntity 클래스에 Auditing 기능을 넣어준다.
public abstract class BaseTimeEntity {  // 모든 엔티티의 상위 클래스가 되어 엔티티들의 생성 날짜, 수정 날짜를 자동관리하는 역할.

    @CreatedDate    // Entity가 생성되어 저장될 때 시간이 자동 저장된다.
    private LocalDateTime createdDate;

    @LastModifiedDate   // 조회한 Entity의 값을 변경할 때 시간이 자동 저장한다.
    private LocalDateTime modifiedDate;

}
