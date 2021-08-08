package org.example.webTest.web;

import lombok.RequiredArgsConstructor;
import org.example.webTest.service.posts.PostsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;

    /*@GetMapping("/")
    public String index(){
        return "index";
    }*/
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        return "index";
    }
    @GetMapping("/posts/save") /*posts-save.mustache를 호출한다. */
    public String postsSave(){
        return "posts-save";
    }
}
