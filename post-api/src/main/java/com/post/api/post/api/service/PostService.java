package com.post.api.post.api.service;

import com.post.api.post.api.dao.PostRepository;
import com.post.api.post.api.model.Post;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostService {
    @Autowired
    PostRepository postRepository;
    public void save(Post post) {
        postRepository.save(post);
    }

    public JSONArray getAll() {
        JSONArray json=new JSONArray();
        List<Post> post=postRepository.findAll();
        for(Post p:post){
            JSONObject obj=setObj(p);
            json.put(obj);
        }
return json;
    }

    private JSONObject setObj(Post p) {
        JSONObject object=new JSONObject();
        object.put("id",p.getId());
        object.put("title",p.getTitle());
        object.put("description",p.getDescription());
        return object;
    }


}
