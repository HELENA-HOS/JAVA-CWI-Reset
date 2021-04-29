package br.com.cwi.reset.exemploreset.aula04.exercicio_chat;

import br.com.cwi.reset.exemploreset.aula04.exercicio_chat.domain.Mensagem;
import br.com.cwi.reset.exemploreset.aula04.exercicio_chat.service.MensagemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/chat")
public class ChatController {

    @Autowired
    private MensagemService mensagemService;

    @GetMapping
    public List<Mensagem> getMensagem(){
        return mensagemService.obterMensagem();

    }

    @PostMapping
    public Mensagem criarMensagem(@RequestBody Mensagem mensagem){
        return mensagemService.criarMensagem(mensagem);

    }
}
