package br.com.escola.gestaoescolar.dominio;

import java.time.LocalDate;

public class Turma {

    // CONSTANTES -> o nome da variavel não segue camelcase, é maiusculo por convenção Java
    // FOI CRIADO COMO ENUM as constantes abaixo
//    public static final String MATUTINO = "MATUTINO";
//    public static final String VESPERTINO = "VESPERTINO";
//    public static final String NOTURNO = "NOTURNO";
//    public static final String SABADOS = "SABADOS";

    private String codigo;
    private Curso curso;
    private LocalDate dataInicio;
    private LocalDate dataFim;
    private Periodo periodo;

    public Turma() {
    }

    public Turma(String codigo, Curso curso, LocalDate dataInicio, LocalDate dataFim, Periodo periodo) {
        this.codigo = codigo;
        this.curso = curso;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
        this.periodo = periodo;
    }

    // Obs. 001 Quando construir o metodo aqui na classe, precisa instanciar uma variavel no br.com.escola.gestaoescolar.Principal (main)
    // para poder chamar o metodo

    /*
    public static void cadastrarTurma(Scanner leitor, ArrayList<br.com.escola.gestaoescolar.Turma> turmas){
        System.out.println("Digite o código da br.com.escola.gestaoescolar.Turma: ");
        var codigo = leitor.nextLine();
        System.out.println("Digite o nome da br.com.escola.gestaoescolar.Turma: ");
        var nome = leitor.nextLine();
        System.out.println("Digite a capacidade da br.com.escola.gestaoescolar.Turma: ");
        var capacidade = Integer.parseInt(leitor.nextLine());
        System.out.println("");

        var turma = new br.com.escola.gestaoescolar.Turma(codigo, nome, capacidade);
        turmas.add(turma);
    }
*/

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    public LocalDate getDataFim() {
        return dataFim;
    }

    public void setDataFim(LocalDate dataFim) {
        this.dataFim = dataFim;
    }

    public Periodo getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Periodo periodo) {
        this.periodo = periodo;
    }
}
