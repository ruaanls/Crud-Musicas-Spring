package br.com.fiap.cp2_java.DTO;

import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatusCode;

import java.util.List;

public class MusicaResponse {
    private Long id;
    private String titulo;
    private Integer anoLancamento;
    private String estilo;
    private String nomeAlbum;
    private List<String> nomesArtistas;


    public MusicaResponse() {
    }


    public MusicaResponse(Long id, String titulo, Integer anoLancamento, String estilo, String nomeAlbum, List<String> nomesArtistas) {
        this.id = id;
        this.titulo = titulo;
        this.anoLancamento = anoLancamento;
        this.estilo = estilo;
        this.nomeAlbum = nomeAlbum;
        this.nomesArtistas = nomesArtistas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public String getEstilo() {
        return estilo;
    }

    public void setEstilo(String estilo) {
        this.estilo = estilo;
    }

    public String getNomeAlbum() {
        return nomeAlbum;
    }

    public void setNomeAlbum(String nomeAlbum) {
        this.nomeAlbum = nomeAlbum;
    }

    public List<String> getNomesArtistas() {
        return nomesArtistas;
    }

    public void setNomesArtistas(List<String> nomesArtistas) {
        this.nomesArtistas = nomesArtistas;
    }
}
