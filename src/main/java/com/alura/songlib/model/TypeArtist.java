package com.alura.songlib.model;

public enum TypeArtist {
    SOLO("Solo"),
    PAIR("Dupla"),
    BAND("Banda");

    private String typeArtist;

    TypeArtist(String typeArtist) {
        this.typeArtist = typeArtist;
    }
}
