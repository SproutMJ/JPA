package domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@ToString
@Getter
@Setter
@Entity //엔티티클래스 명명
@Table(name = "MEMBER") // 매핑할 테이블(없을 경우 테이블 이름으로 매핑
public class Member {
    @Id //기본키 매핑
    @Column(name = "ID") //필드를 컬럼에 매핑
    private String id;
    @Column(name = "NAME")
    private String username;
    //매핑 어노테이션이 없는 경우 변수명으로 매핑
    private Integer age;
}
