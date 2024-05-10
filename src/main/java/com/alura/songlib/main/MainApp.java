package com.alura.songlib.main;

import com.alura.songlib.model.Artist;
import com.alura.songlib.model.Song;
import com.alura.songlib.model.TypeArtist;
import com.alura.songlib.repository.ArtistRepository;
import com.alura.songlib.repository.SongRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class MainApp {

    private final ArtistRepository artistRepository;
    private final SongRepository songRepository;

    private final Scanner scanner = new Scanner(System.in);
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
            var option = scanner.nextLine();

            if (option.equals("9")) {
                System.out.println("""
                        ****************************
                        *** The app has finished ***
                        ****************************
                        """);
                break;
            }

            switch (option) {
                case "1":
                    registerArtist();
                    break;
                case "2":
                    registerSong();
                    break;
                case "3":
                    listSongs();
                    break;
                case "4":
                    searchSongByArtist();
                    break;
                case "5":
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
            var artistName = scanner.nextLine();

            System.out.println("PLace the artist type (solo, due, band): ");
            var artistType = scanner.nextLine();

            TypeArtist type = TypeArtist.fromInput(artistType);

            var artists = new Artist(type, artistName);
            artistRepository.save(artists);


            System.out.println("Keep registering artists? (S/N): ");
            var newRegister = scanner.nextLine();

            if (newRegister.equals("N") | newRegister.equals("n")) {
                break;
            }
        }
    }

    private void registerSong() {
        while (true) {
            var newSong = new Song();

            System.out.println("Place the title: ");
            var title = scanner.nextLine();
            newSong.setTitle(title);

            System.out.println("PLace the album: ");
            var album = scanner.nextLine();
            newSong.setAlbum(album);

            System.out.println("Place the artist: ");
            var artistName = scanner.nextLine();

            var artist = artistRepository.findByNameContainingIgnoreCase(artistName);
            if (artist.isPresent()) {
                newSong.setArtist(artist.get());
                songRepository.save(newSong);
            } else {
                System.out.println("There's not a artist with there artist!!");
            }

            System.out.println("Keep registering songs? (S/N): ");
            var newRegister = scanner.nextLine();

            if (newRegister.equals("N") | newRegister.equals("n")) {
                break;
            }
        }
    }

    private void listSongs() {
        songs = songRepository.findAll();
        System.out.println("""
                        
                        ************************
                        *** Songs registered ***
                        ************************
                        """);
        songs.stream()
                .sorted(Comparator.comparing(Song::getTitle))
                .forEach(System.out::println);
    }

    private void searchSongByArtist() {
        System.out.println("PLace the artist name: ");
        var artistName = scanner.nextLine();

        songs = songRepository.findSongByArtist(artistName);
        System.out.println("""
                        
                        ***********************
                        *** Songs by Artist ***
                        ***********************
                        """);
        songs.forEach(System.out::println);
    }
}
