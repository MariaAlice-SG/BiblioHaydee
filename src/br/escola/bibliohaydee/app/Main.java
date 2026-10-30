
package br.escola.bibliohaydee.app;

import br.escola.bibliohaydee.model.Autor;
import br.escola.bibliohaydee.model.Livro;
import br.escola.bibliohaydee.model.Usuario;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n===== BIBLIOTECA HAYDÉE =====");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Listar usuários");
            System.out.println("3 - Alterar usuário");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            String entrada = scanner.nextLine();

            try {
                opcao = Integer.parseInt(entrada);
            } catch (NumberFormatException e) {
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    cadastrarUsuario(scanner, usuarios);
                    break;

                case 2:
                    listarUsuarios(usuarios);
                    break;

                case 3:
                    alterarUsuario(scanner, usuarios);
                    break;

                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();

        exibirAcervo();
    }

    private static void cadastrarUsuario(
            Scanner scanner, ArrayList<Usuario> usuarios) {

        String nome;

        do {
            System.out.print("Digite o nome do usuário: ");
            nome = scanner.nextLine();

            if (nome.isBlank()) {
                System.out.println("O nome não pode ficar vazio.");
            }
        } while (nome.isBlank());

        String matricula;

        do {
            System.out.print("Digite a matrícula do usuário: ");
            matricula = scanner.nextLine().trim();

            if (matricula.isBlank()) {
                System.out.println("A matrícula não pode ficar vazia.");
            } else if (buscarUsuario(usuarios, matricula) != null) {
                System.out.println("Essa matrícula já está cadastrada.");
                matricula = "";
            }
        } while (matricula.isBlank());

        String tipo;

        do {
            System.out.print("Digite o tipo (ALUNO ou PROFESSOR): ");
            tipo = scanner.nextLine().trim().toUpperCase();

            if (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR")) {
                System.out.println("Tipo inválido. Tente novamente.");
            }
        } while (!tipo.equals("ALUNO") && !tipo.equals("PROFESSOR"));

        Integer limite = Usuario.LIMITE_PADRAO;

        String resposta;

        do {
            System.out.print("Definir o limite de empréstimos? (S/N): ");
            resposta = scanner.nextLine().trim().toUpperCase();

            if (!resposta.equals("S") && !resposta.equals("N")) {
                System.out.println("Digite S para sim ou N para não.");
            }
        } while (!resposta.equals("S") && !resposta.equals("N"));

        if (resposta.equals("S")) {
            while (true) {
                System.out.print("Digite o limite de empréstimos: ");
                String valor = scanner.nextLine();

                try {
                    limite = Integer.parseInt(valor);

                    if (limite < 1) {
                        System.out.println("O limite deve ser maior que zero.");
                        continue;
                    }

                    break;

                } catch (NumberFormatException e) {
                    System.out.println("Digite um número inteiro válido.");
                }
            }
        }

        Usuario usuario;

        if (resposta.equals("N")) {
            usuario = new Usuario(nome, matricula, tipo);
        } else {
            usuario = new Usuario(nome, matricula, tipo, limite);
        }

        usuarios.add(usuario);

        System.out.println("\nUsuário cadastrado com sucesso!");
        System.out.println(usuario);
    }

    private static Usuario buscarUsuario(
            ArrayList<Usuario> usuarios, String matricula) {

        for (Usuario usuario : usuarios) {
            if (usuario.getMatricula().equals(matricula)) {
                return usuario;
            }
        }

        return null;
    }

    private static void listarUsuarios(ArrayList<Usuario> usuarios) {

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        System.out.println("\n===== USUÁRIOS CADASTRADOS =====");

        for (Usuario usuario : usuarios) {
            System.out.println("--------------------");
            System.out.println("Nome: " + usuario.getNome());
            System.out.println("Matrícula: " + usuario.getMatricula());
            System.out.println("Tipo: " + usuario.getTipo());
            System.out.println("Limite de empréstimos: "
                    + usuario.getLimiteEmprestimos());
            System.out.println("Empréstimos ativos: "
                    + usuario.getEmprestimosAtivos());
        }
    }

    private static void alterarUsuario(
            Scanner scanner, ArrayList<Usuario> usuarios) {

        System.out.print("Digite a matrícula do usuário: ");
        String matricula = scanner.nextLine().trim();

        Usuario usuario = buscarUsuario(usuarios, matricula);

        if (usuario == null) {
            System.out.println(
                    "Usuário não localizado. Nenhuma alteração feita.");
            return;
        }

        System.out.println("Usuário encontrado: " + usuario.getNome());
        System.out.println("1 - Alterar nome");
        System.out.println("2 - Alterar limite de empréstimos");
        System.out.print("Escolha uma opção: ");

        String opcao = scanner.nextLine();

        if (opcao.equals("1")) {

            System.out.print("Digite o novo nome: ");
            String novoNome = scanner.nextLine();

            if (usuario.setNome(novoNome)) {
                System.out.println("Nome alterado com sucesso!");
            } else {
                System.out.println("Nome inválido. Nenhuma alteração feita.");
            }

        } else if (opcao.equals("2")) {

            System.out.print("Digite o novo limite: ");
            String valor = scanner.nextLine();

            try {
                int novoLimite = Integer.parseInt(valor);

                if (usuario.setLimiteEmprestimos(novoLimite)) {
                    System.out.println("Limite alterado com sucesso!");
                } else {
                    System.out.println(
                            "Limite inválido. Nenhuma alteração feita.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Digite um número inteiro válido.");
            }

        } else {
            System.out.println("Opção inválida. Nenhuma alteração feita.");
        }
    }

    private static void exibirAcervo() {

        ArrayList<Autor> autores = new ArrayList<>();
        ArrayList<Livro> livros = new ArrayList<>();

        Autor autor = new Autor();

        autor.setNome("Machado de Assis");
        autor.setNacionalidade("Brasileira");
        autor.setAnoNascimento(1839);

        autores.add(autor);

        Livro livro = new Livro(
                "Dom Casmurro",
                "978-85-01-00001-1",
                autor,
                1899,
                "Romance"
        );

        livros.add(livro);

        System.out.println("\n===== ACERVO DA BIBLIOTECA =====");
        System.out.println(autor);
        System.out.println("Quantidade de livros: " + livros.size());
        System.out.println(livro);
    }
}
