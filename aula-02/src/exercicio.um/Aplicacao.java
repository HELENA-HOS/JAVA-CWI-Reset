package exercicio.um;

public class Aplicacao {
    public static void main(String[] args) {

      Diretor diretor = new Diretor("José", 38, 8);
      Filme harry = new Filme("Harry Potter", "Ficção", 128, 2000, 4, diretor);
      Filme avengers = new Filme("Avengers", "Aventura", 90, 2010, 5, diretor);

    harry.reproduzir();

    avengers.reproduzir();

    };

}

