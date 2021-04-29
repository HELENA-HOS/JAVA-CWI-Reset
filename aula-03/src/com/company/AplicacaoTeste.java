package com.company;

import com.company.domain.Editora;
import com.company.domain.Filme;
import com.company.enumeradores.Genero;
import com.company.heranca.Diretor;

public class AplicacaoTeste {

    public static void main(String[] args) {

//        Editora editora1 = new Editora("DC Comics", "São Paulo - SP");
//        Editora editora2 = new Editora("Casinha", "São Paulo - SP");
//
//
//        System.out.println("Editora: " + editora1.getNome());
//        System.out.println("Editora: " + editora2.getNome());

        Diretor diretor1 = new Diretor("José", 38, 2, Genero.MASCULINO);


        Filme batman = new Filme("Batman","Aventura",120,1990,8,diretor1);

        System.out.println("Filme" + batman);


    }

}
