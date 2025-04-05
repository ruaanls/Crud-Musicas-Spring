package br.com.fiap.cp2_java.Controller;

import br.com.fiap.cp2_java.DTO.MusicaRequestDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/musicas")
public class MusicaController
{
    @PostMapping
    public ResponseEntity<MusicaResponse> addMusica(@RequestBody MusicaRequestDTO musicaRequest)
    {
        System.out.println("TESTE");
    }
}
