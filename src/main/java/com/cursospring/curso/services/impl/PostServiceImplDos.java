package com.cursospring.curso.services.impl;

import com.cursospring.curso.model.Post;
import com.cursospring.curso.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {
    @Override
    public List<Post> validationId(List<Post> posts) {
        System.out.println("Segundo servicio");
        for (Post post : posts){
            if(post.getId()==0){
                throw new NullPointerException("El id esta nulo" +
                        "");
            }
        }
        return posts;
    }
}
