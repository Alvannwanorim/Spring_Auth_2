package com.alvan.springauth.posts;


import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    @GetMapping("/logged-in-user")
    public ResponseEntity<Object> getLoggedInUserPosts(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if(principal instanceof UserDetails){
            String username = ((UserDetails)principal).getUsername();
            return ResponseEntity.ok(postService.getLoggedInUserPosts( username));
        }
        return null;

    }

    @GetMapping()
    public ResponseEntity<Object> getPosts(){
        return ResponseEntity.ok(postService.getPosts());
      
    }
    @GetMapping("/{user}")
    public ResponseEntity<Object> getPostByUser(@PathVariable("userId") String userId){
        return ResponseEntity.ok(postService.getPostByUser(userId));
      
    }
    @GetMapping("/{postId}")
    public ResponseEntity<Object> getPost(@PathVariable("postId") String postId){
        return ResponseEntity.ok(postService.getPost(postId));
      
    }
    @PutMapping("/{postId}")
    public ResponseEntity<Object> updatePost(@PathVariable("postId") String postId){
        return ResponseEntity.ok(postService.updatePost(postId));
      
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Object> deletePost(@RequestParam(name = "postId") String postId){
        return ResponseEntity.ok(postService.deletePost(postId));
      
    }
}
