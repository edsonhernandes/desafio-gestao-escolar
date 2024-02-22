package br.com.escola.gestaoescolar.dominio;

public enum Nivel {

    MATUTINO("Matutino"),
    VESPERTINO("Vespertino"),
    NOTURNO("Noturno"),
    SABADOS("Sábados");

    private final String nome;

//    Periodo(String nome) {
//        this.nome = nome;
//    }

    public String getNome() {
        return nome;
    }

}
