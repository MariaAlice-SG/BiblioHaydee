package br.escola.bibliohaydee.model;

public class Usuario {
    private String nome;
    private String matricula;
    private String tipo;
    private Integer limiteEmprestimos;
    private Integer emprestimosAtivos;

    public Usuario(String nomeRecebido, String matriculaRecebida,
                   String tipoRecebido, Integer limiteRecebido) {

        if (nomeRecebido == null || nomeRecebido.isBlank()) {
            throw new IllegalArgumentException("O nome não pode ficar vazio.");
        }

        if (tipoRecebido == null ||
                (!tipoRecebido.equals("ALUNO") &&
                        !tipoRecebido.equals("PROFESSOR"))) {
            throw new IllegalArgumentException(
                    "O tipo deve ser ALUNO ou PROFESSOR."
            );
        }

        nome = nomeRecebido;
        matricula = matriculaRecebida;
        tipo = tipoRecebido;
        limiteEmprestimos = limiteRecebido;
        emprestimosAtivos = 0;
    }
    public String getNome() {
        return nome;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getTipo() {
        return tipo;
    }

    public Integer getLimiteEmprestimos() {
        return limiteEmprestimos;
    }

    public Integer getEmprestimosAtivos() {
        return emprestimosAtivos;
    }
}
