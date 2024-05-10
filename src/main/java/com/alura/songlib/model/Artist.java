package com.alura.songlib.model;

import jakarta.persistence.*;

import java.util.List;


@Entity
@Table(name="artists")
public class Artist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Enumerated(EnumType.STRING)
    private TypeArtist type;

    @OneToMany(mappedBy = "artist", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Song> song;

    public Artist() {
    }

    public Artist(TypeArtist type, String name) {
        this.type = type;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TypeArtist getType() {
        return type;
    }

    public void setType(TypeArtist type) {
        this.type = type;
    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        song.forEach(e -> e.setArtist(this)); // to provide foreign
        this.song = song;
    }
}
