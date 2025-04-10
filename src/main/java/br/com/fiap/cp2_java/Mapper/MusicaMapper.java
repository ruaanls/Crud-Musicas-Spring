package br.com.fiap.cp2_java.Mapper;

import br.com.fiap.cp2_java.DTO.AlbumRequest;
import br.com.fiap.cp2_java.DTO.MusicaRequestDTO;
import br.com.fiap.cp2_java.DTO.MusicaResponse;
import br.com.fiap.cp2_java.Model.Album;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Model.Musica;

import java.util.stream.Collectors;

public class MusicaMapper
{
    public Musica requestToMusica(MusicaRequestDTO musicaRequestDTO)
    {
        Musica musica = new Musica();
        musica.setNome(musicaRequestDTO.getTitulo());
        musica.setAnoLancamento(musicaRequestDTO.getAnoLancamento());
        musica.setEstilo(musicaRequestDTO.getEstilo());
        return musica;
    }

    public MusicaResponse musicaToResponse(Musica musica)
    {
        String autores = musica.getArtistas().stream().map(Artista::getNome).collect(Collectors.joining(", "));
        return new MusicaResponse(musica.getId(),  musica.getNome(), autores + " - ");
    }



}
