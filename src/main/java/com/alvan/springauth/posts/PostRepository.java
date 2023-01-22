package com.alvan.springauth.posts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Posts,Long> {
    List<Posts> findPostsByUser(String userId);

    Posts findById(String postId);

    Object findByPostId(String postId);

    Object findByUserId(Long userId);
    
}
