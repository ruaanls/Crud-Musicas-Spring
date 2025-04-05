package br.com.fiap.cp2_java.Model;

public enum Estilo
{
    ROCK("Rock"),
    POP("Pop"),
    INDIE("Indie"),
    RAP("RAP"),
    PAGODE("PAGODE"),
    OUTROS("Outros Estilos");

    private String descricao;

    Estilo(String descricao)
    {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
