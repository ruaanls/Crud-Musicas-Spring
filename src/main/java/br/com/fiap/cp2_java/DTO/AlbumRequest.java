package br.com.fiap.cp2_java.DTO;

import br.com.fiap.cp2_java.Model.Estilo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class AlbumRequest
{
    @NotBlank(message = "O título da música não pode ser nulo ou vazio")
    @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres")
    private String titulo;
    @NotBlank(message = "A definição de um estilo para o album é obrigatório, valores Nulos não são válidos")
    private Estilo estilo;
    @NotBlank(message = "A definição de um artista para o album é obrigatório, valores Nulos não são válidos")
    private long  artista;
    @NotBlank(message = "A definição de músicas é obrigatório, valores Nulos não são válidos")
    private List<MusicaRequestDTO> musicas;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public long getArtista() {
        return artista;
    }

    public void setArtista(long artista) {
        this.artista = artista;
    }

    public List<MusicaRequestDTO> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<MusicaRequestDTO> musicas) {
        this.musicas = musicas;
    }
}
