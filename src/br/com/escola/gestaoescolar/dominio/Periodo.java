package br.com.escola.gestaoescolar.dominio;

public enum Periodo {

//    MATUTINO,
//    VESPERTINO,
//    NOTURNO,
//    SABADOS;

    //Caso queira personalizar o periodo com minusculas, faz conforme abaixo, criando atributos, construtor, método

    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno"),
    SABADOS("Sabados");

    private final String nome;

    private Periodo(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
