package com.cursospring.curso.services.impl;

import com.cursospring.curso.model.Post;
import com.cursospring.curso.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceDecorado")
public class PostServiceDecoradoImp implements PostService {

    @Autowired
    private PostServiceImpl postServiceImpl;
    @Autowired
    private PostServiceImplDos postServiceImplDos;

    @Override
    public List<Post> validation(List<Post> posts) {
        posts = postServiceImpl.validation(posts);
        posts = postServiceImplDos.validation(posts);

        for (Post post : posts){
            if(post.getDescripcion()==null){
                throw new NullPointerException("La descripcion es nula" +
                        "");
            }
            if(post.getFecha()==null){
                throw new NullPointerException("La Fecha es nula" +
                        "");
            }
        }

        System.out.println("Esta es la clase decorada");
        return posts;
    }
}
