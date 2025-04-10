package br.com.fiap.cp2_java.Controller;

import br.com.fiap.cp2_java.DTO.ArtistaRequest;
import br.com.fiap.cp2_java.DTO.ArtistaResponse;
import br.com.fiap.cp2_java.Mapper.ArtistaMapper;
import br.com.fiap.cp2_java.Mapper.MusicaMapper;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Repository.ArtistaRepository;
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

@RestController
@RequestMapping("/artista")
public class ArtistaController
{

    @Autowired
    private MusicaService musicaService;
    private final MusicaMapper musicaMapper = new MusicaMapper();
    @Autowired
    private ArtistaService artistaService;
    @Autowired
    private AlbumService albumService;

    @PostMapping
    public ResponseEntity<ArtistaResponse> addArtista(@Valid @RequestBody ArtistaRequest artistaRequest)
    {
        Artista artista = new Artista();
        artista.setNome(artistaRequest.getNome());
        return new ResponseEntity<>(artistaService.saveArtista(artista), HttpStatus.CREATED);
    }


}
