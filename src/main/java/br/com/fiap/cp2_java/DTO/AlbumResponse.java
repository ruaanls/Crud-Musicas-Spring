package br.com.fiap.cp2_java.DTO;

import org.springframework.hateoas.RepresentationModel;

import java.util.List;

public class AlbumResponse
{

    private Long id;
    private String titulo;
    private String nomeArtista;
    private String Estilo;
    private List<MusicaAlbum> musicas;


    public AlbumResponse() {
    }


    public AlbumResponse(Long id, String titulo, String nomeArtista, String estilo) {
        this.id = id;
        this.titulo = titulo;
        this.nomeArtista = nomeArtista;
        this.Estilo = estilo;
    }

    public AlbumResponse(Long id, String titulo, String nomeArtista, String estilo, List<MusicaAlbum> musicas) {
        this.id = id;
        this.titulo = titulo;
        this.nomeArtista = nomeArtista;
        Estilo = estilo;
        this.musicas = musicas;
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

    public String getNomeArtista() {
        return nomeArtista;
    }

    public void setNomeArtista(String nomeArtista) {
        this.nomeArtista = nomeArtista;
    }

    public String getEstilo() {
        return Estilo;
    }

    public void setEstilo(String estilo) {
        Estilo = estilo;
    }

    public List<MusicaAlbum> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<MusicaAlbum> musicas) {
        this.musicas = musicas;
    }
}
