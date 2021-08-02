package org.example.webTest.domain.posts;
//실제 데이터베이스 테이블과 매칭될 클래스. entitiy 클래스라 불림.
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.example.webTest.domain.BaseTimeEntity;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //엔티티 클래스. --> 엔티티 클래스에서는 setter 메소드를 만들지 않는다.
public class Posts extends BaseTimeEntity {
    @Id //해당 테이블의 primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =500 , nullable =false) //테이블의 칼럼
    private String title;

    @Column(columnDefinition ="TEXT",nullable = false)
    private String content;

    private String author;

    @Builder //setter 대신에 생성 시점에 값을 채워주어야 한다. 생성자, builder
    public Posts(String title, String content, String author){
        this.title= title;
        this.content = content;
        this.author = author;
    }

    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

}
