package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();

        Autor autor = new Autor();

        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileira");
        autor.setAnoNascimento(1839);

        autores.add(autor);
        System.out.println(autor);

        Livro livro = new Livro(
                "Dom Casmurro",
                "978-85-01-00001-1",
                autor,
                1899,
                "Romance"
        );
        livros.add(livro);

        if (livros.isEmpty()) {
            System.out.println("Acervo vazio.");

        }
        System.out.println("Quantidade de livros: " + livros.size());

        System.out.println(livro);
    }
}