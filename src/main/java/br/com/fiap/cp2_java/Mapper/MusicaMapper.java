package br.com.fiap.cp2_java.Mapper;

import br.com.fiap.cp2_java.Controller.MusicaController;
import br.com.fiap.cp2_java.DTO.MusicaAlbum;
import br.com.fiap.cp2_java.DTO.MusicaRequest;
import br.com.fiap.cp2_java.DTO.MusicaResponse;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Model.Musica;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@Component
public class MusicaMapper
{
    public Musica requestToMusica(MusicaRequest musicaRequest) {
        if (musicaRequest == null) {
            return null;
        }
        Musica musica = new Musica();
        musica.setNome(musicaRequest.getTitulo());
        musica.setAnoLancamento(musicaRequest.getAnoLancamento());
        musica.setEstilo(musicaRequest.getEstilo());

        return musica;
    }


    public List<MusicaResponse> musicaListToResponseList(List<Musica> musicas) {
        if (musicas == null) {
            return null;
        }
        return musicas.stream()
                .map(this::musicaToResponse)
                .collect(Collectors.toList());
    }


    public MusicaResponse musicaToResponse(Musica musica) {
        if (musica == null) {
            return null;
        }


        String nomeAlbum = (musica.getAlbum() != null) ? musica.getAlbum().getNome() : "Sem Álbum"; // Ou null, se preferir


        List<String> nomesArtistas = musica.getArtistas()
                .stream()
                .map(Artista::getNome)
                .collect(Collectors.toList());


        String estiloStr = (musica.getEstilo() != null) ? musica.getEstilo().name() : null;


        return new MusicaResponse(
                musica.getId(),
                musica.getNome(),
                musica.getAnoLancamento(),
                estiloStr,
                nomeAlbum,
                nomesArtistas
        );
    }

    public MusicaAlbum musicaToMusicaAlbum(Musica musica)
    {
        if (musica == null) {
            return null;
        }

        String nomesArtistas = musica.getArtistas().stream()
                .map(Artista::getNome)
                .collect(Collectors.joining(", "));


        MusicaAlbum musicas = new MusicaAlbum();
        musicas.setTitulo(musica.getNome());
        musicas.setNomesArtistas(nomesArtistas);
        musicas.setId(musica.getId());
        musicas.add(linkTo(methodOn(MusicaController.class)
                .getMusicaById(musica.getId()))
                .withSelfRel());
        return musicas;
    }



}
