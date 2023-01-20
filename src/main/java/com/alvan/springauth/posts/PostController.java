package com.alvan.springauth.posts;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/posts")
public class PostController {

    final PostService postService;
    
    @PostMapping("/create")
    public ResponseEntity<Object> createPost(@RequestBody PostRequest request){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String username = ((UserDetails)principal).getUsername();
            return ResponseEntity.ok(postService.createPost(request, username));
        }
        return null;

    }

    @GetMapping()
    public ResponseEntity<Object> getPosts(){
        return ResponseEntity.ok(postService.getPosts());
      
    }
}
