package com.cursospring.curso.components;

import com.cursospring.curso.model.Post;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component ("com.cursospring.curso.components.PostComponent")
public class PostComponent {
    public List<Post> getPosts(){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Mandalorian"));
        post.add(new Post(2, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Grogu"));
        post.add(new Post(3, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Nando"));
        post.add(new Post(4, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Mandalorianos"));



        return post;
    }

}
