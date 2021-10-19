package com.cursospring.curso;

import com.cursospring.curso.components.PostComponent;
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

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        postComponent.getPosts().forEach(p->{
            System.out.println(p.getDescripcion());
        });
    }
}
