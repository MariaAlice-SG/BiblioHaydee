package br.escola.bibliohaydee.model;

public class Usuario {
    public static final int LIMITE_PADRAO = 3;
    private static boolean nomeValido(String nome) {
        return nome != null && !nome.isBlank();
    }
    private static boolean limiteValido(int limite) {
        return limite >= 1;
    }
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
         public Usuario(String nomeRecebido, String matriculaRecebida,
                String tipoRecebido) {
            this(nomeRecebido, matriculaRecebida, tipoRecebido, LIMITE_PADRAO);
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
    public boolean setNome(String nome) {
        if (!nomeValido(nome)) {
            return false;
        }

        this.nome = nome.trim();
        return true;
    }
    public boolean setLimiteEmprestimos(int limiteEmprestimos) {
        if (!limiteValido(limiteEmprestimos)) {
            return false;
        }

        this.limiteEmprestimos = limiteEmprestimos;
        return true;
    }
    @Override
    public String toString() {
        return "Nome: " + nome +
                "\nMatrícula: " + matricula +
                "\nTipo: " + tipo +
                "\nLimite de empréstimos: " + limiteEmprestimos +
                "\nEmpréstimos ativos: " + emprestimosAtivos;
    }
}



