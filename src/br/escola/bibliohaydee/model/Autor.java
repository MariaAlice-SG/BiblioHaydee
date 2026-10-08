package br.escola.bibliohaydee.model;

public class Autor {
    private String nome;
    private String nacionalidade;
    private int anoNascimento;

    public Autor() {
    }
    public void setNome(String nome) {
        if (nome == null || nome.isBlank()) {
            throw new IllegalArgumentException("O nome do autor não pode estar vazio.");
        }
        this.nome = nome;
    }
    public void setNacionalidade(String nacionalidade) {
        this.nacionalidade = nacionalidade;
    }
    public void setAnoNascimento(int anoNascimento) {
        this.anoNascimento = anoNascimento;
    }
    @Override
    public String toString() {
        return "Autor{" +
                "nome='" + nome + '\'' +
                ", nacionalidade='" + nacionalidade + '\'' +
                ", anoNascimento=" + anoNascimento +
                '}';

    }
}
