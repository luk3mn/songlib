package com.alura.songlib.model;

public enum TypeArtist {
    SOLO("Solo"),
    DUE("Due"),
    BAND("Band");

    private String typeArtist;

    TypeArtist(String typeArtist) {
        this.typeArtist = typeArtist;
    }

    public static TypeArtist fromInput(String typeText) {
        for (TypeArtist type : TypeArtist.values()) {
            if (type.typeArtist.equalsIgnoreCase(typeText)) {
                return type;
            }
        }
        throw new IllegalArgumentException("There's no exist such type artist: " + typeText);
    }
}
