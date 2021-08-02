package org.example.webTest.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
                                        //<entitiyl 클래스, pk 타입>
public interface PostsRepository extends JpaRepository<Posts,Long> {

}
