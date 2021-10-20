package com.cursospring.curso.services.impl;

import com.cursospring.curso.model.Post;
import com.cursospring.curso.services.PostService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("serviceDos")
public class PostServiceImplDos implements PostService {
    private final Log log = LogFactory.getLog(getClass());
    @Override
    public List<Post> validation(List<Post> posts) throws NullPointerException{
        log.info("Servicio 2");
        for (Post post : posts){
            if(post.getId()==0){
                throw new NullPointerException("El id esta nulo" +
                        "");
            }
        }
        return posts;
    }
}
