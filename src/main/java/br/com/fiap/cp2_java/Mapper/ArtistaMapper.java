package br.com.fiap.cp2_java.Mapper;

import br.com.fiap.cp2_java.DTO.ArtistaRequest;
import br.com.fiap.cp2_java.DTO.ArtistaResponse;
import br.com.fiap.cp2_java.Model.Artista;
import org.springframework.stereotype.Component;

@Component
public class ArtistaMapper
{
    public Artista requestToArtista(ArtistaRequest artistaRequest) {

        Artista artista = new Artista();
        artista.setNome(artistaRequest.getNome());

        return artista;

    }

    public ArtistaResponse artistaToResponse(Artista artista) {

        if (artista == null) {
            return null;
        }
        return new ArtistaResponse(artista.getId(), artista.getNome());
    }

}
