package br.com.fiap.cp2_java.Service;

import br.com.fiap.cp2_java.DTO.MusicaRequestDTO;
import br.com.fiap.cp2_java.DTO.MusicaResponse;
import br.com.fiap.cp2_java.Mapper.MusicaMapper;
import br.com.fiap.cp2_java.Model.Musica;
import br.com.fiap.cp2_java.Repository.MusicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MusicaService
{
    private final MusicaRepository musicaRepository;
    private final MusicaMapper musicaMapper = new MusicaMapper();
    @Autowired
    public MusicaService(MusicaRepository musicaRepository)
    {
        this.musicaRepository = musicaRepository;
    }

    public MusicaResponse save(Musica musica)
    {
        return musicaMapper.musicaToResponse(musica);
    }

    public List<Musica> saveAll(List<MusicaRequestDTO> musicaRequestDTO)
    {
        List<Musica> musicas = new ArrayList<>();
        for(MusicaRequestDTO musicaRequestDTO1 : musicaRequestDTO)
        {
            musicas.add(musicaMapper.requestToMusica(musicaRequestDTO1));
        }
        return musicaRepository.saveAll(musicas);
    }

}
