package br.com.fiap.cp2_java.Repository;

import br.com.fiap.cp2_java.Model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MusicaRepository extends JpaRepository<Musica, Long>
{
    // Busca músicas associadas a um álbum específico pelo ID do álbum
    List<Musica> findByAlbumId(Long albumId);

    // CORRIGIDO: Busca músicas que tenham um artista com o ID fornecido
    // dentro de sua coleção 'artistas'.
    List<Musica> findByArtistasId(Long artistaId);
}
