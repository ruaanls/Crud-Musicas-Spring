package br.com.fiap.cp2_java.Mapper;

import br.com.fiap.cp2_java.DTO.ArtistaRequest;
import br.com.fiap.cp2_java.DTO.ArtistaResponse;
import br.com.fiap.cp2_java.Model.Artista;

public class ArtistaMapper
{
    public Artista requestToArtista(ArtistaRequest artistaRequest)
    {
        return new Artista(artistaRequest.getNome());
    }

    public ArtistaResponse artistaToResponse(Artista artista)
    {
        return new ArtistaResponse(artista.getId(), artista.getNome());
    }


}
