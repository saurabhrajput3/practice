package com.post.api.post.api.controller;

import com.post.api.post.api.model.Post;
import com.post.api.post.api.service.PostService;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/post-api")
public class PostController {
    @Autowired
    PostService postService;

    public ResponseEntity<String> createPost(@RequestBody String bodyPost){
        Post post=null;
        post=setPost(bodyPost);
        postService.save(post);

        return new ResponseEntity<>("saved", HttpStatus.CREATED);
    }

    public ResponseEntity<String> getAllPost(){
        JSONArray postArray=postService.getAll();
        return new ResponseEntity<>(postArray.toString(),HttpStatus.OK);
    }

    public Post setPost(String bodyPost){
        Post post=new Post();
        JSONObject json =new JSONObject(bodyPost);

        post.setId(json.getInt("id"));
        post.setTitle(json.getString("title"));
        post.setDescription(json.getString("description"));
return post;
    }

}
