package com.cursospring.curso;

import com.cursospring.curso.components.PostComponent;
import com.cursospring.curso.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {

    @Autowired
    @Qualifier("com.cursospring.curso.components.PostComponent")
    public PostComponent postComponent;

    @Autowired
    @Qualifier("serviceDos")
    public PostService postService;

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        /*
        postComponent.getPosts().forEach(p->{
            System.out.println(p.getDescripcion());
        });
        */

        postService.validationId(postComponent.getPosts())
                .forEach((post)->{
                    System.out.println(post.getTitulo());
                });
    }



}
