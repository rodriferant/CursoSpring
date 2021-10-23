package com.cursospring.curso;

import com.cursospring.curso.components.PostComponent;
import com.cursospring.curso.services.PostService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@SpringBootApplication
public class CursoSpringApplication implements CommandLineRunner {


    @Autowired
    private JdbcTemplate jdbcTemplate;

    public CursoSpringApplication(){

    }

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //

        Path path = Paths.get("src/main/resources/import.sql");
        Log log = LogFactory.getLog(getClass());
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, Charset.forName("UTF-8"))){
            String line;
            while ((line = bufferedReader.readLine()) != null){
                jdbcTemplate.execute(line);
            }
        }catch (IOException ex){

        }
    }

    /*
    @Autowired
    @Qualifier("com.cursospring.curso.components.PostComponent")
    public PostComponent postComponent;

    //@Autowired //ayuda a inyectar
    //@Qualifier("serviceDecorado")
    public PostService postService;

    public PostService getPostService() {
        return postService;
    }

    @Autowired //ayuda a inyectar
    @Qualifier("serviceDecorado")
    public void setPostService(PostService postService) {
        this.postService = postService;
    }

    public static void main(String[] args) {
        SpringApplication.run(CursoSpringApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

     */
        /*
        postComponent.getPosts().forEach(p->{
            System.out.println(p.getDescripcion());
        });
        */
    /*
        Log log = LogFactory.getLog(getClass());

        try{
            postService.validation(postComponent.getPosts())
                    .forEach((post)->{
                        log.info(post.getTitulo());
                    });
        }catch (Exception e){
           log.error(e);
        }


    }
    */


}
