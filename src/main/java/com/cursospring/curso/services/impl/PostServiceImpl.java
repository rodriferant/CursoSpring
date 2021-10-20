package com.cursospring.curso.services.impl;

import com.cursospring.curso.model.Post;
import com.cursospring.curso.services.PostService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PostServiceImpl implements PostService {

    private final Log log = LogFactory.getLog(getClass());
    @Override
    public List<Post> validation(List<Post> posts) throws NullPointerException {
        log.info("Servicio 1");
        for (Post post : posts){
            if(post.getTitulo()==null){
                throw new NullPointerException("No tiene el titulo");
            }
        }
        return posts;
    }
}
