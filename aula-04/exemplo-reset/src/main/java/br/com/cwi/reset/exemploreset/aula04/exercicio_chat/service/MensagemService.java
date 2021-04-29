package br.com.cwi.reset.exemploreset.aula04.exercicio_chat.service;

import br.com.cwi.reset.exemploreset.aula04.exercicio4.exceptions.BadRequestException;
import br.com.cwi.reset.exemploreset.aula04.exercicio_chat.domain.Mensagem;
import br.com.cwi.reset.exemploreset.aula04.exercicio_chat.repository.MensagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class MensagemService {


    @Autowired
    private MensagemRepository repository;



    public List<Mensagem> obterMensagem(){
        return repository.getMensagens();
    }


    public Mensagem criarMensagem(Mensagem mensagem){
        if (mensagem == null || mensagem.getAutor() == null || mensagem.getMensagem() == null) {
            throw new BadRequestException();
        }
        return repository.addMensagem(mensagem);
    }

}
