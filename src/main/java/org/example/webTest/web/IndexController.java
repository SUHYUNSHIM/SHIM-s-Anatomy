package org.example.webTest.web;

import lombok.RequiredArgsConstructor;
import org.example.webTest.config.auth.LoginUser;
import org.example.webTest.config.auth.dto.SessionUser;
import org.example.webTest.service.posts.PostsService;
import org.example.webTest.web.dto.PostsResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {
    private final PostsService postsService;
    private final HttpSession httpSession;

  /*  @GetMapping("/")
    public String index(){
        return "index";
    }*/

    @GetMapping("/posts/save") /*posts-save.mustache를 호출한다. */
    public String postsSave(){
        return "posts-save";
    }

    @GetMapping("/posts/update/{id}")
    public String postsUpdate(@PathVariable Long id, Model model){
        PostsResponseDto dto = postsService.findById(id);
        model.addAttribute("post",dto);
        return "posts-update";
    }

 /*   @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("posts", postsService.findAllDesc());
        SessionUser user = (SessionUser)httpSession.getAttribute("user");
        if(user !=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }*/
    @GetMapping("/")
    public String index(Model model, @LoginUser SessionUser user){
        model.addAttribute("posts",postsService.findAllDesc());
        if(user !=null){
            model.addAttribute("userName",user.getName());
        }
        return "index";
    }
}
