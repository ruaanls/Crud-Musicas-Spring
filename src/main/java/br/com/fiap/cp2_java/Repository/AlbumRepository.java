package br.com.fiap.cp2_java.Repository;

import br.com.fiap.cp2_java.Model.Album;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumRepository extends JpaRepository<Album, Long>
{
    Page<Album> findByArtistasId(Long artistaId, Pageable pageable);
}
