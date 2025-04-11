package br.com.fiap.cp2_java.Mapper;

import br.com.fiap.cp2_java.DTO.AlbumRequest;
import br.com.fiap.cp2_java.DTO.AlbumResponse;
import br.com.fiap.cp2_java.DTO.ArtistaRequest;
import br.com.fiap.cp2_java.DTO.MusicaAlbum;
import br.com.fiap.cp2_java.Model.Album;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Model.Musica;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AlbumMapper
{

    private final MusicaMapper musicaMapper;

    public AlbumMapper(MusicaMapper musicaMapper) {
        this.musicaMapper = musicaMapper;
    }


    public Album requestToAlbum(AlbumRequest albumRequest) {
        if (albumRequest == null) {
            return null;
        }
        Album album = new Album();
        album.setNome(albumRequest.getTitulo());
        album.setEstilo(albumRequest.getEstilo());

        return album;
    }

    public AlbumResponse albumToResponse(Album album) {
        if (album == null) {
            return null;
        }

        String nomeArtista = (album.getArtistas() != null) ? album.getArtistas().getNome() : null;
        List<MusicaAlbum> musicasDoAlbum = new ArrayList<>();
        for(Musica musicaEncontrada: album.getMusicas())
        {
            musicasDoAlbum.add(this.musicaMapper.musicaToMusicaAlbum(musicaEncontrada));
        }
        return new AlbumResponse(
                album.getId(),
                album.getNome(),
                nomeArtista,
                album.getEstilo().toString(),
                musicasDoAlbum
        );
    }



}
