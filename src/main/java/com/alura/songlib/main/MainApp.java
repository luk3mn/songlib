package com.alura.songlib.main;

import com.alura.songlib.model.Artist;
import com.alura.songlib.model.Song;
import com.alura.songlib.repository.ArtistRepository;
import com.alura.songlib.repository.SongRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private ArtistRepository artistRepository;
    private SongRepository songRepository;

    private final Scanner scanner = new Scanner(System.in);
    private List<Artist> artists = new ArrayList<>();
    private List<Song> songs = new ArrayList<>();

    public MainApp(ArtistRepository artistRepository, SongRepository songRepository) {
        this.artistRepository = artistRepository;
        this.songRepository = songRepository;
    }

    public void showMenu() {
        while(true) {
            System.out.println("""
                    [1] Register artist
                    [2] Register song
                    [3] List songs
                    [4] Search song by artist
                    [5] Search artist information
                    
                    [9] Exit
                    """);
            var option = scanner.nextInt();

            if (option == 9) {
                System.out.println("""
                        ****************************
                        *** The app has finished ***
                        ****************************
                        """);
                break;
            }

            switch (option) {
                case 1:
                    registerArtist();
                    break;
                case 2:
                    System.out.println("2");
                    break;
                case 3:
                    listSongs();
                    break;
                case 4:
                    searchSongByArtist();
                    break;
                case 5:
                    System.out.println("5");
                    break;
                default:
                    System.out.println("Invalid Option");
            }
        }
    }

    private void registerArtist() {
        while (true) {
            System.out.println("Place the artist name: ");
            var artistName = scanner.next();

            System.out.println("PLace the artist type (solo, due, band): ");
            var artistType = scanner.next();

            System.out.println("Keep registering artists? (S/N): ");
            var newRegister = scanner.next();

            if (newRegister.equals("N") | newRegister.equals("n")) {
                break;
            }
        }
    }

    private void listSongs() {
        songs = songRepository.findAll();
        songs.stream()
                .sorted(Comparator.comparing(Song::getTitle))
                .forEach(System.out::println);
    }

    private void searchSongByArtist() {
        System.out.println("PLace the artist name: ");
        var artistName = scanner.next();

        songs = songRepository.findSongByArtist(artistName);
        songs.forEach(System.out::println);
    }
}
