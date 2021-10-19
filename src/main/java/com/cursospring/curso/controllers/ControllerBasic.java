package com.cursospring.curso.controllers;

import com.cursospring.curso.components.PostComponent;
import com.cursospring.curso.configuration.Paginas;
import com.cursospring.curso.model.Post;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/home")
public class ControllerBasic {

    /*
    public List<Post> getPosts(){
        ArrayList<Post> post = new ArrayList<>();
        post.add(new Post(1, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Mandalorian"));
        post.add(new Post(2, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Grogu"));
        post.add(new Post(3, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Nando"));
        post.add(new Post(4, "Los Mandalorianos eran un grupo cultural humano que se originó en el planeta Mandalore.", "http://localhost:8080/img/post.jpg", new Date(), "Mandalorianos"));



        return post;
    }
    */
    @Autowired
    private PostComponent _postComponent;


    @GetMapping (path = {"/posts","/"})
    public String saludar(Model model){
        model.addAttribute("posts",this._postComponent.getPosts());
        return "index";
    }

    @GetMapping(path = "/public")
    public ModelAndView post(){
        ModelAndView modelAndView = new ModelAndView(Paginas.HOME);
        modelAndView.addObject("posts", this._postComponent.getPosts());
        return modelAndView;
    }

    @GetMapping (path = {"/post", "/post/p/{post}"})
    public ModelAndView getPostIndividual(
            @PathVariable(required = true, name = "post") int id
            ){
        ModelAndView modelAndView = new ModelAndView(Paginas.POST);
         //para filtrar el post
        List<Post> postFiltrado = this._postComponent.getPosts().stream().filter((p)-> {return p.getId() == id;}).collect(Collectors.toList());
        modelAndView.addObject("post", postFiltrado.get(0));
        return modelAndView;
        //estaba arriba donde Path
        //@RequestParam (defaultValue = "1", name = "id", required = false)
    }

    @GetMapping("/postNew")
    public ModelAndView getForm(){
        return new ModelAndView("form").addObject("post",new Post());
    }

    @PostMapping("/addNewPost")
    public String addNewPost(Post post, Model model){
        List<Post> posts = this._postComponent.getPosts();
        posts.add(post);
        model.addAttribute("posts", posts);
        return "index";
    }

}
