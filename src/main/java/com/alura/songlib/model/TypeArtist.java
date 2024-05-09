package com.alura.songlib.model;

public enum TypeArtist {
    SOLO("Solo"),
    DUE("Dupla"),
    BAND("Banda");

    private String typeArtist;

    TypeArtist(String typeArtist) {
        this.typeArtist = typeArtist;
    }
}
