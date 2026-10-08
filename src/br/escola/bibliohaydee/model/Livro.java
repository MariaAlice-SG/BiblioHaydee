package br.escola.bibliohaydee.model;

public class Livro {

    private String titulo;
    private String isbn;
    private Autor autor;
    private int anoPublicacao;
    private String genero;
    private boolean disponivel;

    public Livro(String titulo, String isbn, Autor autor, int anoPublicacao, String genero) {

        if (autor == null) {
            throw new IllegalArgumentException("O livro precisa ter um autor.");
        }

        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.genero = genero;
        this.disponivel = true;
    }
    @Override
    public String toString() {
        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", isbn='" + isbn + '\'' +
                ", autor=" + autor +
                ", anoPublicacao=" + anoPublicacao +
                ", genero='" + genero + '\'' +
                ", disponivel=" + disponivel +
                '}';
    }
}
