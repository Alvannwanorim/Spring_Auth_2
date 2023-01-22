package com.alvan.springauth.posts;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends CrudRepository<Posts,Long> {
    List<Posts> findPostsByUserId(String userId);

    @Query(
        nativeQuery = true,
        value = "SELECT * FROM post_entity WHERE id=?1"
    )
    Object findByUserId(Long userId);
    
}
