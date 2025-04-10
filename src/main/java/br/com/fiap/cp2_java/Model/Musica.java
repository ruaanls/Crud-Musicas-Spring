package br.com.fiap.cp2_java.Model;

import jakarta.persistence.*;

import java.util.List;

@Entity

public class Musica
{
    //FALTA OS RELACIONAMENTOS AINDA
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    private int anoLancamento;
    private Estilo estilo;
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "musica_artista", joinColumns = @JoinColumn(name = "musica_id"), inverseJoinColumns = @JoinColumn(name = "artista_id"))
    private List<Artista> artistas;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "album_id")
    private Album album;

    public Musica() {
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

    public int getAnoLancamento() {
        return anoLancamento;
    }

    public void setAnoLancamento(int anoLancamento) {
        this.anoLancamento = anoLancamento;
    }

    public Estilo getEstilo() {
        return estilo;
    }

    public void setEstilo(Estilo estilo) {
        this.estilo = estilo;
    }

    public List<Artista> getArtistas() {
        return artistas;
    }

    public void setArtistas(List<Artista> artistas) {
        this.artistas = artistas;
    }

    public Album getAlbum() {
        return album;
    }

    public void setAlbum(Album album) {
        this.album = album;
    }
}
