package br.com.fiap.cp2_java.DTO;

import br.com.fiap.cp2_java.Model.Estilo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public class AlbumRequest
{
    @NotBlank(message = "O título do álbum não pode ser nulo ou vazio")
    @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres")
    private String titulo;

    @NotNull(message = "A definição de um estilo para o album é obrigatório")
    private Estilo estilo;

    @NotNull(message = "O ID do artista para o álbum é obrigatório")
    @Positive(message = "O ID do artista deve ser um número positivo")
    private Long artistaId;


    public @NotBlank(message = "O título do álbum não pode ser nulo ou vazio") @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank(message = "O título do álbum não pode ser nulo ou vazio") @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres") String titulo) {
        this.titulo = titulo;
    }

    public @NotNull(message = "A definição de um estilo para o album é obrigatório") Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(@NotNull(message = "A definição de um estilo para o album é obrigatório") Estilo estilo) {
        this.estilo = estilo;
    }

    public @NotNull(message = "O ID do artista para o álbum é obrigatório") @Positive(message = "O ID do artista deve ser um número positivo") Long getArtistaId() {
        return artistaId;
    }

    public void setArtistaId(@NotNull(message = "O ID do artista para o álbum é obrigatório") @Positive(message = "O ID do artista deve ser um número positivo") Long artistaId) {
        this.artistaId = artistaId;
    }
}
