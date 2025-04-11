package br.com.fiap.cp2_java.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Artista
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToMany(mappedBy = "artistas", fetch = FetchType.LAZY)
    private List<Musica> musicas = new ArrayList<>();
    @OneToMany(mappedBy = "artistas", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    private List<Album> albuns = new ArrayList<>();

    public Artista() {
    }

    public Artista(String nome) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void setMusicas(List<Musica> musicas) {
        this.musicas = musicas;
    }

    public List<Album> getAlbuns() {
        return albuns;
    }

    public void setAlbuns(List<Album> albuns) {
        this.albuns = albuns;
    }
}
