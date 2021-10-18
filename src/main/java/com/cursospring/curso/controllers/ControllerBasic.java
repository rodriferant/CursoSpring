package com.cursospring.curso.controllers;

import com.cursospring.curso.configuration.Paginas;
import com.cursospring.curso.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class ControllerBasic {


    public List<Post> getPosts(){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Mandalorian"));
        post.add(new Post(2, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Grogu"));
        post.add(new Post(3, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Nando"));
        post.add(new Post(4, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Mandalorianos"));



        return post;
    }


    @GetMapping (path = {"/posts","/"})
    public String saludar(Model model){
        model.addAttribute("posts",this.getPosts());
        return "index";
    }

    @GetMapping(path = "/public")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
        modelAndView.addObject("posts", this.getPosts());
        return modelAndView;
    }

    @GetMapping (path = {"/post", "/post/p/{post}"})
    public ModelAndView getPostIndividual(
            @PathVariable(required = true, name = "post") int id
            ){
        ModelAndView modelAndView = new ModelAndView(Paginas.POST);
         //para filtrar el post
        List<Post> postFiltrado = this.getPosts().stream().filter((p)-> {return p.getId() == id;}).collect(Collectors.toList());
        modelAndView.addObject("post", postFiltrado.get(0));
        return modelAndView;
        //estaba arriba donde Path
        //@RequestParam (defaultValue = "1", name = "id", required = false)
    }


}
