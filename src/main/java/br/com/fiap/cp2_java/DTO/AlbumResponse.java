package br.com.fiap.cp2_java.DTO;

public class AlbumResponse
{
    private long id;
    private String titulo;
    private String artistas;


    public AlbumResponse(long id, String titulo, String artistas) {
        this.id = id;
        this.titulo = titulo;
        this.artistas = artistas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getArtistas() {
        return artistas;
    }

    public void setArtistas(String artistas) {
        this.artistas = artistas;
    }
}
