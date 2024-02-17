package br.com.escola.gestaoescolar.funcionalidades;

import br.com.escola.gestaoescolar.dominio.Estudante;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;

public class CadastroDeEstudante {

    private Path arquivo;

    public CadastroDeEstudante(){

        try{
            this.arquivo = Path.of("estudantes.csv");   //***Criando o metodo cadastrarEstudante com Files/Path
            if (!Files.exists(arquivo)) {
                Files.createFile(arquivo);               }
        }catch (Exception e) {
            System.out.println("Erro ao criar arquivo de estudantes!");
        }
    }

    public void cadastrar(Estudante estudante){
        //validações:
        if(estudante.getNome().isBlank()){
            throw new IllegalArgumentException("Campo nome é obrigatório");
        }

        if(estudante.getTelefone().isBlank()){
            throw new IllegalArgumentException("Campo telefone é obrigatório");
        }

        if(estudante.getEndereco().isBlank()){
            throw new IllegalArgumentException("Campo endereço é obrigatório");
        }

        if(estudante.getCpf().isBlank()){
            throw new IllegalArgumentException("Campo cpf é obrigatório");
        }

        if(estudante.getEmail().isBlank()){
            throw new IllegalArgumentException("Campo email é obrigatório");
        }

        try {
            Files.writeString(arquivo, estudante.getNome() + "," + estudante.getTelefone() + "," +
                    estudante.getEndereco() + "," + estudante.getCpf() + "," + estudante.getEmail() +
                    "\n", StandardOpenOption.APPEND);
        }catch (Exception e){
//            *** Para mostrar a StackTrace usa o nome da variavel da Exception no caso e + printStackTrace, conf
//            abaixo, isso serve apenas para localizar o erro mais facilmente, depois pode comentar a linha ou excluir
            e.printStackTrace();
            System.out.println("Erro ao cadastrar estudante no arquivo");
        }

    }

    public ArrayList<Estudante> listar(){
        var lista = new ArrayList<Estudante>();

        try {
            var linhas = Files.readAllLines(arquivo);

            for (var linha : linhas){
                var campos = linha.split(",");
                var estudante = new Estudante(campos[0] , campos[1] , campos[2] , campos[3], campos[4]);
                lista.add(estudante);

//                System.out.println(campos[0] + " - " + campos[1] + " - " + campos[2] + " - " + campos[3]);
//            System.out.println(linha);
//                System.out.println("");

            }

            return lista;


        }catch (Exception e){
            System.out.println("Erro ao carregar estudantes do arquivo!");
            return lista;
        }

    }
}




