package br.com.fiap.cp2_java.DTO;

import br.com.fiap.cp2_java.Model.Album;
import br.com.fiap.cp2_java.Model.Estilo;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.List;

public class MusicaRequestDTO
{
    @NotBlank(message = "O título da música não pode ser nulo ou vazio")
    @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres")
    private String titulo;
    @NotBlank(message = "Uma música deve pertencer a um album")
    @Size(min = 5, max = 254, message = "O album deve ter entre 5 e 254 caracteres")
    private long album;
    @NotBlank(message = "Uma música deve ter ao menos 1 artista/banda e ele não deve ser nulo")
    private List<ArtistaRequest> artistas;
    @NotBlank(message = "Uma música deve ter um ano de lançamento válido e não nulo")
    @Min(value = 1860, message = "O ano de lançamento deve ser no mínimo 1860")
    @Max(value = 2025, message = "O ano de lançamento deve ser no máximo 2025")
    private int anoLancamento;
    @NotBlank(message = "A definição de um estilo para a música é obrigatório, valores Nulos não são válidos")
    private Estilo estilo;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public long getAlbum() {
        return album;
    }

    public void setAlbum(long album) {
        this.album = album;
    }

    public List<ArtistaRequest> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<ArtistaRequest> artistas) {
        this.artistas = artistas;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }
}
