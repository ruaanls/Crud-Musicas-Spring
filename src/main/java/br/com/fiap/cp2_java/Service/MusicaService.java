package br.com.fiap.cp2_java.Service;

import br.com.fiap.cp2_java.DTO.MusicaRequest;
import br.com.fiap.cp2_java.DTO.MusicaResponse;
import br.com.fiap.cp2_java.Exception.ValidationExceptionHandler;
import br.com.fiap.cp2_java.Mapper.MusicaMapper;
import br.com.fiap.cp2_java.Model.Album;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Model.Musica;
import br.com.fiap.cp2_java.Repository.AlbumRepository;
import br.com.fiap.cp2_java.Repository.ArtistaRepository;
import br.com.fiap.cp2_java.Repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class MusicaService
{
    private final MusicaRepository musicaRepository;
    private final AlbumRepository albumRepository;
    private final ArtistaRepository artistaRepository;
    private final MusicaMapper musicaMapper;


    public MusicaService(MusicaRepository musicaRepository,
                         AlbumRepository albumRepository,
                         ArtistaRepository artistaRepository,
                         MusicaMapper musicaMapper) {
        this.musicaRepository = musicaRepository;
        this.albumRepository = albumRepository;
        this.artistaRepository = artistaRepository;
        this.musicaMapper = musicaMapper;
    }



    public MusicaResponse createMusica(MusicaRequest musicaRequest) {

        Long albumId = musicaRequest.getAlbumId();
        Album album = albumRepository.findById(albumId)
                .orElseThrow(() -> new ValidationExceptionHandler.ResourceNotFoundException("Álbum não encontrado com ID: " + albumId + " para associar à música."));


        List<Long> artistaIds = musicaRequest.getArtistaIds();
        if (artistaIds == null || artistaIds.isEmpty()) {
            throw new IllegalArgumentException("Lista de IDs de artistas não pode ser nula ou vazia.");
        }
        List<Artista> artistas = artistaRepository.findAllById(artistaIds);




        Musica musicaToSave = musicaMapper.requestToMusica(musicaRequest);


        musicaToSave.setAlbum(album);
        musicaToSave.setArtistas(artistas);


        Musica savedMusica = musicaRepository.save(musicaToSave);


        return musicaMapper.musicaToResponse(savedMusica);
    }



    public MusicaResponse save(Musica musica) {

        Musica savedMusica = musicaRepository.save(musica);
        return musicaMapper.musicaToResponse(savedMusica);
    }



    public List<MusicaResponse> saveAll(List<Musica> musicas) {
        List<Musica> savedMusicas = musicaRepository.saveAll(musicas);

        return musicaMapper.musicaListToResponseList(savedMusicas);
    }



    public Musica findMusicaById(Long id) {
        return musicaRepository.findById(id)
                .orElseThrow(() -> new ValidationExceptionHandler.ResourceNotFoundException("Música não encontrada com ID: " + id));
    }


    public MusicaResponse findMusicaResponseById(Long id) {
        Musica musica = findMusicaById(id);
        return musicaMapper.musicaToResponse(musica);
    }


    public Page<MusicaResponse> findAllMusicas(Pageable pageable) {
        return musicaRepository.findAll(pageable)
                .map(musicaMapper::musicaToResponse);

    }


    public List<MusicaResponse> findMusicasByAlbumId(Long albumId) {

        if (!albumRepository.existsById(albumId)) {
            throw new ValidationExceptionHandler.ResourceNotFoundException("Álbum não encontrado com ID: " + albumId);
        }
        return musicaRepository.findByAlbumId(albumId).stream()
                .map(musicaMapper::musicaToResponse)
                .collect(Collectors.toList());
    }


    public List<MusicaResponse> findMusicasByArtistaId(Long artistaId) {

        if (!artistaRepository.existsById(artistaId)) {
            throw new ValidationExceptionHandler.ResourceNotFoundException("Artista não encontrado com ID: " + artistaId);
        }
        return musicaRepository.findByArtistasId(artistaId).stream() // Usa o método CORRIGIDO do repo
                .map(musicaMapper::musicaToResponse)
                .collect(Collectors.toList());
    }


    public void deleteMusicaById(Long id) {
        if (!musicaRepository.existsById(id)) {
            throw new ValidationExceptionHandler.ResourceNotFoundException("Música não encontrada com ID: " + id);
        }
        musicaRepository.deleteById(id);
    }

}
