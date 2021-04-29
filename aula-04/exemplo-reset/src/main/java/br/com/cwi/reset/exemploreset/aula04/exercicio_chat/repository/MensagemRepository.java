package br.com.cwi.reset.exemploreset.aula04.exercicio_chat.repository;

import br.com.cwi.reset.exemploreset.aula04.exercicio_chat.domain.Mensagem;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class MensagemRepository {

    static List<Mensagem> mensagens = new ArrayList<>();


    public List<Mensagem> getMensagens(){
        return mensagens;
    }


    public Mensagem addMensagem(Mensagem mensagem){
        mensagens.add(mensagem);
        return mensagem;
    }
}
