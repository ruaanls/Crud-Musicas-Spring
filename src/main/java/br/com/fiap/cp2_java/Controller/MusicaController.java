package br.com.fiap.cp2_java.Controller;

import br.com.fiap.cp2_java.DTO.MusicaRequestDTO;
import br.com.fiap.cp2_java.DTO.MusicaResponse;
import br.com.fiap.cp2_java.Mapper.AlbumMapper;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/musicas")
public class MusicaController
{
    @Autowired
    private MusicaService musicaService;
    private final MusicaMapper musicaMapper = new MusicaMapper();
    @Autowired
    private ArtistaService ArtistaService;
    private AlbumService albumService;
    private AlbumMapper albumMapper;
    @Autowired

    @PostMapping
    public ResponseEntity<MusicaResponse> addMusica(@Valid @RequestBody MusicaRequestDTO musicaRequest)
    {
        List<Artista> artistas = ArtistaService.saveAllArtistas(musicaRequest.getArtistas());
        Album album = albumService.findAlbumById(musicaRequest.getAlbum());
        Musica musica = musicaMapper.requestToMusica(musicaRequest);
        musica.setArtistas(artistas);
        musica.setAlbum(album);
        return new ResponseEntity<>(musicaService.save(musica), HttpStatus.CREATED);

    }

    @PostMapping("/musicas/all")
    public ResponseEntity<List<MusicaResponse>> addManyMusics(@Valid @RequestBody List<MusicaRequestDTO> musicaRequestDTOS)
    {
        List<Musica> musicas;
        for(MusicaRequestDTO musicaRequest: musicaRequestDTOS)
        {
            List<Artista> artistas = ArtistaService.saveAllArtistas(musicaRequest.getArtistas());
            Album album = albumService.findAlbumById(musicaRequest.getAlbum());
            Musica musica = musicaMapper.requestToMusica(musicaRequest);
            musica.setArtistas(artistas);
            musica.setAlbum(album);
        }
    }
}
