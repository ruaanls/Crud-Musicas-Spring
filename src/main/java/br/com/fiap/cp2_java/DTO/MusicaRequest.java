package br.com.fiap.cp2_java.DTO;

import br.com.fiap.cp2_java.Model.Estilo;
import jakarta.validation.constraints.*;

import java.util.List;

public class MusicaRequest
{
    @NotBlank(message = "O título da música não pode ser nulo ou vazio")
    @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres")
    private String titulo;

    @NotNull(message = "O ID do álbum é obrigatório")
    @Positive(message = "O ID do álbum deve ser positivo")
    private Long albumId;

    @NotEmpty(message = "Uma música deve ter ao menos 1 ID de artista")

    private List<@NotNull @Positive Long> artistaIds;

    @NotNull(message = "O ano de lançamento é obrigatório")
    @Min(value = 1860, message = "O ano de lançamento deve ser no mínimo 1860")
    @Max(value = 2025, message = "O ano de lançamento deve ser no máximo 2025")
    private Integer anoLancamento;

    @NotNull(message = "A definição de um estilo para a música é obrigatório")
    private Estilo estilo;


    public @NotBlank(message = "O título da música não pode ser nulo ou vazio") @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres") String getTitulo() {
        return titulo;
    }

    public void setTitulo(@NotBlank(message = "O título da música não pode ser nulo ou vazio") @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres") String titulo) {
        this.titulo = titulo;
    }

    public @NotNull(message = "O ID do álbum é obrigatório") @Positive(message = "O ID do álbum deve ser positivo") Long getAlbumId() {
        return albumId;
    }

    public void setAlbumId(@NotNull(message = "O ID do álbum é obrigatório") @Positive(message = "O ID do álbum deve ser positivo") Long albumId) {
        this.albumId = albumId;
    }

    public @NotEmpty(message = "Uma música deve ter ao menos 1 ID de artista") List<@NotNull @Positive Long> getArtistaIds() {
        return artistaIds;
    }

    public void setArtistaIds(@NotEmpty(message = "Uma música deve ter ao menos 1 ID de artista") List<@NotNull @Positive Long> artistaIds) {
        this.artistaIds = artistaIds;
    }

    public @NotNull(message = "O ano de lançamento é obrigatório") @Min(value = 1860, message = "O ano de lançamento deve ser no mínimo 1860") @Max(value = 2025, message = "O ano de lançamento deve ser no máximo 2025") Integer getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(@NotNull(message = "O ano de lançamento é obrigatório") @Min(value = 1860, message = "O ano de lançamento deve ser no mínimo 1860") @Max(value = 2025, message = "O ano de lançamento deve ser no máximo 2025") Integer anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public @NotNull(message = "A definição de um estilo para a música é obrigatório") Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(@NotNull(message = "A definição de um estilo para a música é obrigatório") Estilo estilo) {
        this.estilo = estilo;
    }
}
