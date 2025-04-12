package br.com.fiap.cp2_java.Controller;

import br.com.fiap.cp2_java.DTO.AlbumRequest;
import br.com.fiap.cp2_java.DTO.AlbumResponse;


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
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.event.HyperlinkEvent;
import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.IanaLinkRelations.SELF;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/albuns") // Plural
public class AlbumController {

    private final AlbumService albumService;
    private final ArtistaService artistaService;


    public AlbumController(AlbumService albumService, ArtistaService artistaService) {
        this.albumService = albumService;
        this.artistaService = artistaService;
    }


    @PostMapping
    public ResponseEntity<AlbumResponse> createAlbum(@Valid @RequestBody AlbumRequest albumRequest) {
        AlbumResponse albumResponse = albumService.createAlbum(albumRequest);
        return new ResponseEntity<>(albumResponse,HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<EntityModel<AlbumResponse>> getAlbumById(@PathVariable Long id) {
        AlbumResponse albumResponse = albumService.findAlbumResponseById(id);
        // Adiciona links HATEOAS
        EntityModel<AlbumResponse> entityModel = EntityModel.of(albumResponse);
        entityModel.add(linkTo(methodOn(AlbumController.class).getAllAlbums()).withRel("albuns"));



        return ResponseEntity.ok(entityModel);
    }

    @GetMapping("/artista/{artistaid}")
    public ResponseEntity<Page<AlbumResponse>> getAlbumByArtistaId(@PathVariable Long id,@RequestParam(defaultValue = "0") Integer pageNumber)
    {
        Pageable pageable = PageRequest.of(pageNumber,2);
        return new ResponseEntity<>(albumService.findAlbumByArtistaId(id,pageable),HttpStatus.CREATED);
    }


    @GetMapping
    public ResponseEntity<List<AlbumResponse>> getAllAlbums() {
        List<AlbumResponse> albuns = albumService.findAllAlbums();

        return new ResponseEntity<>(albuns,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AlbumResponse> updateAlbum(@PathVariable Long id, @RequestBody AlbumRequest albumRequest)
    {
        Album album = albumService.findAlbumById(id);

        Artista artista = artistaService.findArtistaById(albumRequest.getArtistaId());
        album.setEstilo(albumRequest.getEstilo());
        album.setNome(albumRequest.getTitulo());
        album.setArtistas(artista);
        return  new ResponseEntity<>(albumService.saveAlbum(album), HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAlbum(@PathVariable Long id) {
        albumService.deleteAlbumById(id);
        return ResponseEntity.noContent().build(); // Retorna 204 No Content
    }


}
