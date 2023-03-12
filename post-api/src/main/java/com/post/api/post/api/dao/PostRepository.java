package com.post.api.post.api.dao;

import com.post.api.post.api.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostRepository extends JpaRepository<Post,Integer> {
    @Query(value = "select * from tbl_post",nativeQuery = true)
    public List<Post> findAll();

}
