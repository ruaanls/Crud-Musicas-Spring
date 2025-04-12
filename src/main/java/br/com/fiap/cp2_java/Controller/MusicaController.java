package br.com.fiap.cp2_java.Controller;

import br.com.fiap.cp2_java.DTO.MusicaRequest;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.IanaLinkRelations.SELF;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/musicas") // Plural
public class MusicaController {

    private final MusicaService musicaService;
    private final AlbumService albumService;
    private final ArtistaService artistaService;


    public MusicaController(MusicaService musicaService, AlbumService albumService, ArtistaService artistaService) {
        this.musicaService = musicaService;
        this.albumService = albumService;
        this.artistaService = artistaService;
    }


    @PostMapping
    public ResponseEntity<MusicaResponse> createMusica(@Valid @RequestBody MusicaRequest musicaRequest) {

        MusicaResponse musicaResponse = musicaService.createMusica(musicaRequest);
        return new ResponseEntity<>(musicaResponse, HttpStatus.CREATED);
    }

    @PostMapping("/all")
    public ResponseEntity<List<MusicaResponse>> createManyMusics(@Valid @RequestBody List<MusicaRequest> musicaRequests)
    {
        List<MusicaResponse> musicaResponse = new ArrayList<>();
        for(MusicaRequest musica: musicaRequests)
        {
            musicaResponse.add(musicaService.createMusica(musica));
        }
        return new ResponseEntity<>(musicaResponse, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<MusicaResponse>> getAllMusicas(@RequestParam(defaultValue = "0") Integer pageNumber)
    {
        Pageable pageable = PageRequest.of(pageNumber, 2);
        return new ResponseEntity<>(musicaService.findAllMusicas(pageable),HttpStatus.CREATED);
    }


    @GetMapping("/id/{id}")
    public ResponseEntity<EntityModel<MusicaResponse>> getMusicaById(@PathVariable Long id) {
        MusicaResponse musicaResponse = musicaService.findMusicaResponseById(id);
        // Adiciona links HATEOAS
        EntityModel<MusicaResponse> entityModel = EntityModel.of(musicaResponse,
                linkTo(methodOn(MusicaController.class).getMusicaById(id)).withSelfRel(),
                linkTo(methodOn(MusicaController.class).getAllMusicas(0)).withRel("musicas"));

        return ResponseEntity.ok(entityModel);
    }

    @PutMapping("/{id}")
    public ResponseEntity<MusicaResponse> updateMusica(@PathVariable Long id, @RequestBody MusicaRequest musicaRequest)
    {
        Musica musica = new Musica();
        Album album = albumService.findAlbumById(musicaRequest.getAlbumId());
        List<Artista> artistas = new ArrayList<>();
        for(Long idEncontrado: musicaRequest.getArtistaIds())
        {
            artistas.add(artistaService.findArtistaById(idEncontrado));
        }
        musica.setAnoLancamento(musicaRequest.getAnoLancamento());
        musica.setNome(musicaRequest.getTitulo());
        musica.setEstilo(musicaRequest.getEstilo());
        musica.setAlbum(album);
        musica.setArtistas(artistas);
        return new ResponseEntity<>(musicaService.save(musica),HttpStatus.CREATED);

    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMusica(@PathVariable Long id) {
        musicaService.deleteMusicaById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }
}

