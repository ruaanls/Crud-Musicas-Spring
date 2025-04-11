package br.com.fiap.cp2_java.Service;

import br.com.fiap.cp2_java.DTO.AlbumRequest;
import br.com.fiap.cp2_java.DTO.AlbumResponse;
import br.com.fiap.cp2_java.Exception.ValidationExceptionHandler;
import br.com.fiap.cp2_java.Mapper.AlbumMapper;
import br.com.fiap.cp2_java.Model.Album;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Repository.AlbumRepository;
import br.com.fiap.cp2_java.Repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumService
{
    private final AlbumRepository albumRepository;
    private final ArtistaRepository artistaRepository;
    private final AlbumMapper albumMapper;


    public AlbumService(AlbumRepository albumRepository,
                        ArtistaRepository artistaRepository,
                        AlbumMapper albumMapper) {
        this.albumRepository = albumRepository;
        this.artistaRepository = artistaRepository;
        this.albumMapper = albumMapper;
    }


    @Transactional
    public AlbumResponse createAlbum(AlbumRequest albumRequest) {

        Long artistaId = albumRequest.getArtistaId();
        Artista artista = artistaRepository.findById(artistaId)
                .orElseThrow(() -> new ValidationExceptionHandler.ResourceNotFoundException("Artista não encontrado com ID: " + artistaId + " para associar ao álbum."));


        Album albumToSave = albumMapper.requestToAlbum(albumRequest);


        albumToSave.setArtistas(artista);


        Album savedAlbum = albumRepository.save(albumToSave);


        return albumMapper.albumToResponse(savedAlbum);
    }


    @Transactional
    public AlbumResponse saveAlbum(Album album) {

        if (album.getArtistas() == null || album.getArtistas().getId() == null) {
            throw new IllegalArgumentException("Álbum deve ter um artista associado para ser salvo.");
        }

        Album savedAlbum = albumRepository.save(album);
        return albumMapper.albumToResponse(savedAlbum);
    }

    @Transactional(readOnly = true)
    public Album findAlbumById(Long id) {
        return albumRepository.findById(id)
                .orElseThrow(() -> new ValidationExceptionHandler.ResourceNotFoundException("Album não encontrado com ID: " + id)); // Usa a exceção correta
    }

    @Transactional(readOnly = true)
    public AlbumResponse findAlbumResponseById(Long id) {
        Album album = findAlbumById(id);
        return albumMapper.albumToResponse(album);
    }

    @Transactional(readOnly = true)
    public List<AlbumResponse> findAllAlbums() {
        return albumRepository.findAll().stream()
                .map(albumMapper::albumToResponse)
                .collect(Collectors.toList());
    }

    @Transactional
    public void deleteAlbumById(Long id) {
        if (!albumRepository.existsById(id)) {
            throw new ValidationExceptionHandler.ResourceNotFoundException("Album não encontrado com ID: " + id);
        }

        albumRepository.deleteById(id);
    }

}
