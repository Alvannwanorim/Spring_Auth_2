package com.alvan.springauth.posts;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Posts,Long> {
    List<Posts> findPostsByUser(String userId);

    Optional<Posts> findById(Long postId);

    Optional<Posts> findByPostId(Long postId);

    Object findByUserId(Long userId);
    
}
