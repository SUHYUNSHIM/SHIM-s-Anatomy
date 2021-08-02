package org.example.webTest.web.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PostsUpdateRequestDto {
    private String title;
    private String content;

    @Builder
    public PostsUpdateRequestDto(String title, String content){
        this.title = title;
        this.content  = content;
    }
    //쿼리를 날리는 부분이 없다. JPA의 콘텍스트 영속성 때문이다.
}
