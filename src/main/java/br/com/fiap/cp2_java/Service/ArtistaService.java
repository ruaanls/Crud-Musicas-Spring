package br.com.fiap.cp2_java.Service;

import br.com.fiap.cp2_java.DTO.ArtistaRequest;
import br.com.fiap.cp2_java.DTO.ArtistaResponse;
import br.com.fiap.cp2_java.Mapper.AlbumMapper;
import br.com.fiap.cp2_java.Mapper.ArtistaMapper;
import br.com.fiap.cp2_java.Model.Artista;
import br.com.fiap.cp2_java.Repository.ArtistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistaService
{
    private final AlbumMapper albumMapper = new AlbumMapper();
    private final ArtistaMapper artistaMapper = new ArtistaMapper();
    private final ArtistaRepository artistaRepository;
    @Autowired
    public ArtistaService( ArtistaRepository artistaRepository)
    {
        this.artistaRepository = artistaRepository;

    }

    public List<Artista> saveAllArtistas(List<ArtistaRequest> artistas)
    {
        List<Artista> artistasSalvos = new ArrayList<>();
        for(ArtistaRequest artista : artistas)
        {
            artistasSalvos.add(artistaMapper.requestToArtista(artista));
        }
        return artistaRepository.saveAll(artistasSalvos);
    }

    public ArtistaResponse saveArtista(Artista artista)
    {
        artistaRepository.save(artista);
        return artistaMapper.artistaToResponse(artista);
    }

    public Artista findArtistaById(long id)
    {
        Optional<Artista> artista = artistaRepository.findById(id);

        return artista.orElse(null);
    }


}
