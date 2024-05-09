package com.alura.songlib.repository;

import com.alura.songlib.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface SongRepository extends JpaRepository<Song, Long> {
    @Query("SELECT s FROM Song s JOIN s.artist a WHERE a.name ILIKE %:artistName%")
    List<Song> findSongByArtist(String artistName);
}
