package br.com.cwi.reset.exemploreset.aula04.teste;


import org.springframework.web.bind.annotation.*;

@RestController

public class HelloWorldController {

    static String mensagem = "Hello World";

    @GetMapping("/hello-world")
    public String helloWorld(){
        return mensagem;
    }

    @PutMapping("/hello-world/{novaMensagem}")
    public String mudarMensagem(@PathVariable("novaMensagem") String novaMensagem) {
        this.mensagem = novaMensagem;
        return this.mensagem;

    }



}
