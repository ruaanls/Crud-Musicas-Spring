package br.com.fiap.cp2_java.DTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ArtistaRequest
{
    @NotBlank(message = "O nome do artista é obrigatório e não pode ser nulo")
    @Size(min = 2, max = 254, message = "O título deve ter entre 2 e 254 caracteres")
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
