package exercicio.um;

public class Aplicacao {
    public static void main(String[] args) {

      Diretor diretor = new Diretor("José", 38, 8, Genero.MASCULINO);
      Filme harry = new Filme("Harry Potter", "Ficção", 128, 2000, 4, diretor);
      Filme avengers = new Filme("Avengers", "Aventura", 90, 2010, 5, diretor);


    harry.reproduzir();

    avengers.reproduzir();

    Ator daniel = new Ator("Daniel", 29, 2, Genero.MASCULINO);

    daniel.imprimirInformacoes();

    Ator lisa = new Ator("Lisa Jones", 37,0, Genero.FEMININO);

    lisa.imprimirInformacoes();

    diretor.imprimirInformacoes();

    }

}

