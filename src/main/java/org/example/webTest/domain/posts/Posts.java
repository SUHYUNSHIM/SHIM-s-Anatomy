package org.example.webTest.domain.posts;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity //엔티티 클래스.
public class Posts {
    @Id //해당 테이블의 primary key field
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length =500 , nullable =false) //테이블의 칼럼
    private String title;

    @Column(columnDefinition ="TEXT",nullable = false)
    private String content;

    private String author;

    @Builder
    public Posts(String title, String content, String author){
        this.title= title;
        this.content = content;
        this.author = author;
    }

}
