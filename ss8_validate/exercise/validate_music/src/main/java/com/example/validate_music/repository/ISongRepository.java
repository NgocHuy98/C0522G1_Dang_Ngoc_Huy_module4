package com.example.validate_music.repository;

import com.example.validate_music.model.Song;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ISongRepository extends JpaRepository<Song,Integer> {

    Song findById(int id);

    List<Song> findByNameSong(String name);
}
