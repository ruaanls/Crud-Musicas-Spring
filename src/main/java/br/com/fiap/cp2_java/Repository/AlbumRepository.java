package br.com.fiap.cp2_java.Repository;

import br.com.fiap.cp2_java.Model.Album;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlbumRepository extends JpaRepository<Album, Long>
{

}
