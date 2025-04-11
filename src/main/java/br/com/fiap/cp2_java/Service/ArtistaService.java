package br.com.fiap.cp2_java.Service;

import br.com.fiap.cp2_java.DTO.ArtistaRequest;
import br.com.fiap.cp2_java.DTO.ArtistaResponse;
import br.com.fiap.cp2_java.Exception.ValidationExceptionHandler;
import br.com.fiap.cp2_java.Mapper.AlbumMapper;
import br.com.fiap.cp2_java.Mapper.ArtistaMapper;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistaService
{
    private final ArtistaRepository artistaRepository;
    private final ArtistaMapper artistaMapper;


    public ArtistaService(ArtistaRepository artistaRepository, ArtistaMapper artistaMapper) {
        this.artistaRepository = artistaRepository;
        this.artistaMapper = artistaMapper;
    }


    @Transactional
    public ArtistaResponse createArtista(ArtistaRequest artistaRequest) {
        Artista artistaToSave = artistaMapper.requestToArtista(artistaRequest);
        Artista savedArtista = artistaRepository.save(artistaToSave);
        return artistaMapper.artistaToResponse(savedArtista);
    }


    @Transactional
    public ArtistaResponse saveArtista(Artista artista) {
        Artista savedArtista = artistaRepository.save(artista);
        return artistaMapper.artistaToResponse(savedArtista);
    }



    @Transactional
    public List<ArtistaResponse> saveAllArtistas(List<Artista> artistas) {
        List<Artista> savedArtistas = artistaRepository.saveAll(artistas);
        return savedArtistas.stream()
                .map(artistaMapper::artistaToResponse)
                .collect(Collectors.toList());
    }


    public Artista findArtistaById(Long id) {
        return artistaRepository.findById(id)
                .orElseThrow(() -> new ValidationExceptionHandler.ResourceNotFoundException("Artista não encontrado com ID: " + id)); // Usa a exceção correta
    }

    @Transactional(readOnly = true)
    public ArtistaResponse findArtistaResponseById(Long id) {
        Artista artista = findArtistaById(id);
        return artistaMapper.artistaToResponse(artista);
    }

    @Transactional(readOnly = true)
    public List<ArtistaResponse> findAllArtistas() {
        return artistaRepository.findAll().stream()
                .map(artistaMapper::artistaToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteArtistaById(Long id) {
        if (!artistaRepository.existsById(id)) {
            throw new ValidationExceptionHandler.ResourceNotFoundException("Artista não encontrado com ID: " + id);
        }
        artistaRepository.deleteById(id);
    }


}
