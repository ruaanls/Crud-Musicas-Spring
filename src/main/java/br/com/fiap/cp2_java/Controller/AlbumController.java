package br.com.fiap.cp2_java.Controller;

import br.com.fiap.cp2_java.DTO.AlbumRequest;
import br.com.fiap.cp2_java.DTO.AlbumResponse;
import br.com.fiap.cp2_java.Mapper.AlbumMapper;
import br.com.fiap.cp2_java.Mapper.ArtistaMapper;
import br.com.fiap.cp2_java.Mapper.MusicaMapper;
import br.com.fiap.cp2_java.Model.Album;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Model.Musica;
import br.com.fiap.cp2_java.Service.AlbumService;
import br.com.fiap.cp2_java.Service.ArtistaService;
import br.com.fiap.cp2_java.Service.MusicaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class AlbumController
{
    @Autowired
    private MusicaService musicaService;
    private final MusicaMapper musicaMapper = new MusicaMapper();
    private final AlbumMapper albumMapper = new AlbumMapper();
    private final ArtistaMapper artistaMapper = new ArtistaMapper();
    @Autowired
    private br.com.fiap.cp2_java.Service.ArtistaService artistaService;
    @Autowired
    private br.com.fiap.cp2_java.Service.AlbumService albumService;

    @PostMapping
    public ResponseEntity<AlbumResponse> createAlbum (@Valid @RequestBody AlbumRequest albumRequest)
    {
        List<Musica> musicas = musicaService.saveAll(albumRequest.getMusicas());
        Artista artista = artistaService.findArtistaById(albumRequest.getArtista());
        Album album = albumMapper.requestToAlbum(albumRequest);
        album.setArtistas(artista);
        album.setMusicas(musicas);
        return new ResponseEntity<>(albumService.saveAlbum(album), HttpStatus.CREATED);
    }

}
