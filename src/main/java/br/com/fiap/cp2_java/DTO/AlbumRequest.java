package br.com.fiap.cp2_java.DTO;

import br.com.fiap.cp2_java.Model.Estilo;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class AlbumRequest
{
    @NotBlank(message = "O título da música não pode ser nulo ou vazio")
    @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres")
    private String titulo;
    @NotBlank(message = "A definição de um estilo para a música é obrigatório, valores Nulos não são válidos")
    private Estilo estilo;
}
