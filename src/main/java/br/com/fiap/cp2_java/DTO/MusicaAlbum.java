package br.com.fiap.cp2_java.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import org.springframework.hateoas.RepresentationModel;

public class MusicaAlbum extends RepresentationModel<MusicaAlbum>
{
    private Long id;
    @NotBlank(message = "O título da música não pode ser nulo ou vazio")
    @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres")
    private String titulo;
    @NotEmpty(message = "Uma música deve ter ao menos 1 artista")
    private String nomesArtistas;


    public MusicaAlbum() {
    }

    public MusicaAlbum(Long id, String titulo, String nomesArtistas) {
        this.id = id;
        this.titulo = titulo;
        this.nomesArtistas = nomesArtistas;
    }

    public @NotBlank(message = "O título da música não pode ser nulo ou vazio") @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank(message = "O título da música não pode ser nulo ou vazio") @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres") String titulo) {
        this.titulo = titulo;
    }

    public @NotEmpty(message = "Uma música deve ter ao menos 1 artista") String getNomesArtistas() {
        return nomesArtistas;
    }

    public void setNomesArtistas(@NotEmpty(message = "Uma música deve ter ao menos 1 artista") String nomesArtistas) {
        this.nomesArtistas = nomesArtistas;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
