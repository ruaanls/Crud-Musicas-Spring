package br.com.fiap.cp2_java.Service;

import br.com.fiap.cp2_java.DTO.AlbumRequest;
import br.com.fiap.cp2_java.DTO.AlbumResponse;
import br.com.fiap.cp2_java.Mapper.AlbumMapper;
import br.com.fiap.cp2_java.Model.Album;
import br.com.fiap.cp2_java.Repository.AlbumRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AlbumService
{
    private final AlbumRepository albumRepository;
    private final AlbumMapper albumMapper;
    @Autowired
    public AlbumService(AlbumRepository albumRepository, AlbumMapper albumMapper) {
        this.albumRepository = albumRepository;
        this.albumMapper = albumMapper;
    }

    public AlbumResponse saveAlbum(Album album)
    {
        albumRepository.save(album);
        return albumMapper.albumToResponse(album);
    }

    public Album findAlbumById(long id)
    {
        Optional<Album> album = albumRepository.findById(id);
        return album.orElse(null);
    }

}
