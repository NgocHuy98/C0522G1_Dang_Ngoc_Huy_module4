package com.example.validate_music.service;


import com.example.validate_music.model.Song;

import java.util.List;

public interface ISongService {

    List<Song> findAll();

    void save(Song song);

    Song findById(int id);

    void update(Song song);

    void remove(Song song);

    List<Song> findName(String name);
}
