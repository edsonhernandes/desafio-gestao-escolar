package br.com.escola.gestaoescolar;

import br.com.escola.gestaoescolar.dominio.Estudante;
import br.com.escola.gestaoescolar.dominio.Turma;
import br.com.escola.gestaoescolar.funcionalidades.CadastroDeEstudante;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

            var leitor = new Scanner(System.in);
            var opcao = 0;
            //        var turma = new Turma();  // Obs. 001 Quando construir o metodo na classe Turma, precisa instanciar uma
            //        variavel aqui no Principal (main) para poder chamar o metodo da classe Turma

            while (opcao != 5) {
                exibirMenu();
                opcao = Integer.parseInt(leitor.nextLine());

                if (opcao == 1) {
//                    cadastrarTurma(leitor, turmas);  ***Chamando o metodo cadastrarTurma com ArrayList
                    cadastrarTurma(leitor);  //***Chamando o metodo cadastrarTurma com Files


                } else if (opcao == 2) {
                    cadastrarEstudante(leitor);

                } else if (opcao == 3) {
//                    listarTurmas(turmas);          ***Chamando o metodo listarTurmas com ArrayList
                    listarTurmas();            //***Chamando o metodo listarTurmas com Files/Path

                } else if (opcao == 4) {
                    listarEstudantes();

                } else if (opcao == 5) {
                    System.out.println("Você saiu do Sistema Gestão Escolar");

                } else if (opcao < 1 || opcao > 5) {
                    System.out.println("Opção inválida, digite uma opção do menu principal");
                }
            }
        }


    private static void exibirMenu() {
        System.out.println("Menu principal: ");
        System.out.println("1 - Cadastrar Turma ");
        System.out.println("2 - Cadastrar Estudante ");
        System.out.println("3 - Listar Turmas ");
        System.out.println("4 - Listar Estudantes ");
        System.out.println("5 - Sair -> ");
        System.out.println("");
        System.out.println("Digite a opção desejada: ");
    }

    //    Criando o metodo cadastrarTurma com Files para salvar um arquivo (CSV,XML,JSON)

    private static void cadastrarTurma(Scanner leitor, Path arquivo) throws IOException {
        System.out.println("Digite o código da Turma: ");
        var codigo = leitor.nextLine();
        System.out.println("");

        var turma = new Turma(codigo, curso);

        Files.writeString(arquivo, turma.getCodigo() + "," +
                turma.getCurso() +"\n", StandardOpenOption.APPEND);
    }

    //    Criando o metodo listarTurmas com Files para listar um arquivo

    private static void listarTurmas(Path arquivo) throws IOException {
        var linhas = Files.readAllLines(arquivo);

        for (var linha : linhas){
//            Se quiser imprimir sem formatar, basta o comando abaixo, vai imprimir o arquivo turmas do
//            jeito que está construido, a linha toda separada por virgulas

//            System.out.println(linha);

//            Caso queira formatar a variavel linha, faz o comando abaixo, pois ela é uma String, para separar uma
//            String usa a extensao split após o nome da variavel, ela mostra que é um regex, voce define o que será
//            usado para separar as colunas, no caso "," e instancia um novo nome de variavel para manipular
//            os dados, que no caso agora é um Array, então define quais os campos quer imprimir e tipo de formatação

            var campos = linha.split(",");
            System.out.println(campos[0] + " - " + campos[1] + " - " + campos[2]);

        }
    }

    private static void cadastrarEstudante(Scanner leitor) throws IOException {

        System.out.println("Digite o nome do Estudante: ");
        var nome = leitor.nextLine();
        System.out.println("Digite o telefone do Estudante: ");
        var telefone = leitor.nextLine();
        System.out.println("Digite o endereço do Estudante: ");
        var endereco = leitor.nextLine();
        System.out.println("Digite o cpf do Estudante: ");
        var cpf = leitor.nextLine();
        System.out.println("Digite o email do Estudante: ");
        var email = leitor.nextLine();
        System.out.println("");

        var estudante = new Estudante(nome, telefone, endereco, cpf, email);

        var cadastro = new CadastroDeEstudante();   // *** para chamar o metodo da Classe CadastroDeEstudante

        try {
            cadastro.cadastrar(estudante);              // *** para chamar o metodo da Classe CadastroDeEstudante

        }catch (IllegalArgumentException e){
            System.out.println("Erro ao cadastrar Estudante: " + e.getMessage());
        }

    }

    private static void listarEstudantes() throws IOException {
        var cadastro = new CadastroDeEstudante();
        var estudantesCadastrados = cadastro.listar();
        for (var estudante : estudantesCadastrados){
            System.out.println(estudante.getNome() + "," + estudante.getTelefone() + "," +
                estudante.getEndereco() + "," + estudante.getCpf() + "," + estudante.getEmail());
        }

    }

}
