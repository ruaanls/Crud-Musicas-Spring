package br.com.fiap.cp2_java.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Album
{
    //FALTA OS RELACIONAMENTOS AINDA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    @ManyToOne(fetch = FetchType.LAZY) // LAZY é geralmente preferível para performance
    @JoinColumn(name = "artista_id")
    private Artista artistas;
    @OneToMany(mappedBy = "album", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    // ACHO QUE FALTA UM JOIN COLUMN AQUI
    private List<Musica> musicas;
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
