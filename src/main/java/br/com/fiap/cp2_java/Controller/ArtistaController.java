package br.com.fiap.cp2_java.Controller;
import br.com.fiap.cp2_java.DTO.ArtistaRequest;
import br.com.fiap.cp2_java.DTO.ArtistaResponse;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Service.ArtistaService;
import jakarta.validation.Valid;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

import static org.springframework.hateoas.IanaLinkRelations.SELF;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@RestController
@RequestMapping("/artistas")
public class ArtistaController {

    private final ArtistaService artistaService;


    public ArtistaController(ArtistaService artistaService) {
        this.artistaService = artistaService;
    }


    @PostMapping
    public ResponseEntity<ArtistaResponse> createArtista(@Valid @RequestBody ArtistaRequest artistaRequest) {

        ArtistaResponse artistaResponse = artistaService.createArtista(artistaRequest);
        return new ResponseEntity<>(artistaResponse, HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ArtistaResponse>getArtistaById(@PathVariable Long id) {
        ArtistaResponse artistaResponse = artistaService.findArtistaResponseById(id);

        return new ResponseEntity<>(artistaResponse,HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<List<ArtistaResponse>> getAllArtistas() {
        List<ArtistaResponse> artistas = artistaService.findAllArtistas();

        return new ResponseEntity<>(artistas,HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ArtistaResponse> updateArtista(@PathVariable Long id, @RequestBody ArtistaRequest artistaRequest)
    {
        Artista artista = artistaService.findArtistaById(id);
        artista.setNome(artistaRequest.getNome());
        return new ResponseEntity<>(artistaService.saveArtista(artista),HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteArtista(@PathVariable Long id) {
        artistaService.deleteArtistaById(id);
        return ResponseEntity.noContent().build();
    }


}