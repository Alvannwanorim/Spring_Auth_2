package com.alvan.springauth.posts;


import org.springframework.stereotype.Service;

import com.alvan.springauth.entity.User;
import com.alvan.springauth.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PostService {

    final PostRepository repository;
    final UserRepository userRepository;

    public Object createPost(PostRequest request, String username) {
        User user = userRepository.findByUsername(username);
        Posts post = new Posts();
        post.setTitle(request.getTitle());
        post.setContent(request.getContent());
        post.setStatus(request.getStatus());
        post.setTags(request.getTags());
        post.setUser(user);
        repository.save(post);
        return post;

    }

    public Object getPosts() {
        return repository.findAll();
    }

    public Object getPostByUser(String userId) {
        return repository.findByUserId(userId);
    }

    public Object getPost(String postId) {
        return repository.findByPostId(postId);
    }

    public Object updatePost(String postId) {
        return repository.findByPostId(postId);
    }

    public Object deletePost(String postId) {
        return null;
    }

    public Object getLoggedInUserPosts(String username) {
        return null;
    }
    
}
