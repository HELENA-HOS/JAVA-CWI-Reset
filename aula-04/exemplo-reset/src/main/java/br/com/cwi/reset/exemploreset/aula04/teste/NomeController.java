package br.com.cwi.reset.exemploreset.aula04.teste;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/nome")

public class NomeController {

    private static String nome = "Maria";


    @GetMapping
    public String getNome() {
        return nome;
    }

    @PutMapping("/{nome}")
    public String putNome(@PathVariable("nome") String novoNome) {
        this.nome = novoNome;
        return this.nome;
    }


    @DeleteMapping
    public void deleteNome() {
        this.nome = null;
    }


}



