package br.com.fiap.cp2_java.Model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity

public class Musica
{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Column(name = "ano_lancamento")
    private int anoLancamento;

    @Enumerated(EnumType.STRING)
    @Column(name = "estilo")
    private Estilo estilo;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "musica_artista",
            joinColumns = @JoinColumn(name = "musica_id"), // FK para Musica na tabela de junção
            inverseJoinColumns = @JoinColumn(name = "artista_id") // FK para Artista na tabela de junção
    )
    private List<Artista> artistas = new ArrayList<>();


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
