package br.com.fiap.cp2_java.Repository;

import br.com.fiap.cp2_java.Model.Artista;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtistaRepository extends JpaRepository<Artista, Long> {
}
