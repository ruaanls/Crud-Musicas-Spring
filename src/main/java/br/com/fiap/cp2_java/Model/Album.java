package br.com.fiap.cp2_java.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Album
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    // Relação Muitos-para-Um com Artista (Álbum pertence a UM artista)
    // Lado DONO da relação. Define a FK na tabela ALBUM.
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artista_id", nullable = false) // Garante que todo álbum tem um artista
    private Artista artistas;

    // Relação Um-para-Muitos com Musica (Álbum tem várias músicas)
    // Lado INVERSO da relação. Mapeado pelo campo 'album' na classe Musica.
    @OneToMany(
            mappedBy = "album",
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.LAZY
    )
    private List<Musica> musicas = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    @Column(name = "estilo")
    private Estilo estilo;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Artista getArtistas() {
        return artistas;
    }

    public void setArtistas(Artista artistas) {
        this.artistas = artistas;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }
}
