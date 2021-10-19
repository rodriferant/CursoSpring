package com.cursospring.curso.services.impl;

import com.cursospring.curso.model.Post;
import com.cursospring.curso.services.PostService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    @Override
    public List<Post> validation(List<Post> posts) {
        System.out.println("Primer servicio");
        for (Post post : posts){
            if(post.getTitulo()==null){
                throw new NullPointerException("No tiene el titulo");
            }
        }
        return posts;
    }
}
