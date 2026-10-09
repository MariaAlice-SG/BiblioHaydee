package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();
        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        String nomeUsuario;
        do {
            System.out.print("Digite o nome do usuário: ");
            nomeUsuario = scanner.nextLine();
            if (nomeUsuario.isBlank()) {
                System.out.println("O nome não pode ficar vazio. Tente novamente.");
            }
        } while (nomeUsuario.isBlank());
        System.out.println("Nome informado: " + nomeUsuario);

        String matriculaUsuario;
        do {
            System.out.print("Digite a matrícula do usuário: ");
            matriculaUsuario = scanner.nextLine();
            if (matriculaUsuario.isBlank()) {
                System.out.println("A matrícula não pode ficar vazia. Tente novamente.");
            }
        } while (matriculaUsuario.isBlank());
        System.out.println("Matrícula informada: " + matriculaUsuario);


        String tipoUsuario;
        do {
            System.out.print("Digite o tipo (ALUNO ou PROFESSOR): ");
            tipoUsuario = scanner.nextLine().trim().toUpperCase();
            if (!tipoUsuario.equals("ALUNO") &&
                    !tipoUsuario.equals("PROFESSOR")) {
                System.out.println("Tipo inválido! Digite ALUNO ou PROFESSOR.");
            }
        } while (!tipoUsuario.equals("ALUNO") &&
                !tipoUsuario.equals("PROFESSOR"));
        System.out.println("Tipo informado: " + tipoUsuario);


        Integer limiteUsuario;
        while (true) {
            System.out.print("Digite o limite de empréstimos: ");
            String limiteDigitado = scanner.nextLine();
            try {
                limiteUsuario = Integer.parseInt(limiteDigitado);
                if (limiteUsuario < 0) {
                    System.out.println("O limite não pode ser negativo. Tente novamente.");
                    continue;
                }
                break;
            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }
        }
        System.out.println("Limite informado: " + limiteUsuario);


        Usuario usuario = new Usuario(
                nomeUsuario,
                matriculaUsuario,
                tipoUsuario,
                limiteUsuario
        );
        usuarios.add(usuario);
        System.out.println("\nUsuário cadastrado com sucesso!");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Matrícula: " + usuario.getMatricula());
        System.out.println("Tipo: " + usuario.getTipo());
        System.out.println("Limite de empréstimos: " + usuario.getLimiteEmprestimos());
        System.out.println("Empréstimos ativos: " + usuario.getEmprestimosAtivos());
        System.out.println("Total de usuários cadastrados: " + usuarios.size());

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