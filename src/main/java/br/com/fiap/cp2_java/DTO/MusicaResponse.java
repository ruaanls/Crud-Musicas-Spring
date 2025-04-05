package br.com.fiap.cp2_java.DTO;

import org.springframework.hateoas.Link;

public class MusicaResponse
{
    private Long id;
    private String infoMusica;
    private Link link;

    public MusicaResponse(Long id, String infoMusica) {
        this.id = id;
        this.infoMusica = infoMusica;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getInfoMusica() {
        return infoMusica;
    }

    public void setInfoMusica(String infoMusica) {
        this.infoMusica = infoMusica;
    }

    public Link getLink() {
        return link;
    }

    public void setLink(Link link) {
        this.link = link;
    }
}
