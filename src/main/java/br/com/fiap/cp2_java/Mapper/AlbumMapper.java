package br.com.fiap.cp2_java.Mapper;

import br.com.fiap.cp2_java.DTO.AlbumRequest;
import br.com.fiap.cp2_java.DTO.AlbumResponse;
import br.com.fiap.cp2_java.DTO.ArtistaRequest;
import br.com.fiap.cp2_java.Model.Album;
import br.com.fiap.cp2_java.Model.Artista;

public class AlbumMapper
{


    public Album requestToAlbum(AlbumRequest albumRequest)
    {
        Album album = new Album();
        album.setEstilo(albumRequest.getEstilo());
        album.setNome(albumRequest.getTitulo());
        return album;
    }

    public AlbumResponse albumToResponse(Album album)
    {
        return new AlbumResponse(album.getId(), album.getNome(), album.getArtistas().getNome());
    }

}
