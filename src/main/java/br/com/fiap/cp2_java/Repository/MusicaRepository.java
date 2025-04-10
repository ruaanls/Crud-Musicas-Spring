package br.com.fiap.cp2_java.Repository;

import br.com.fiap.cp2_java.Model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MusicaRepository extends JpaRepository<Musica, Long>
{
    List<Musica> findByAlbumId(Long albumId);
    List<Musica> findByArtistaId(Long artistaId);
}
