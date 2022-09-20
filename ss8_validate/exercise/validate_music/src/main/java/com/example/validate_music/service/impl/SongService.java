package com.example.validate_music.service.impl;
import com.example.validate_music.model.Song;
import com.example.validate_music.repository.ISongRepository;
import com.example.validate_music.service.ISongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService implements ISongService {
    @Autowired
    private ISongRepository iSongRepository;


    @Override
    public List<Song> findAll() {
        return null;
    }

    @Override
    public void save(Song song) {

    }

    @Override
    public Song findById(int id) {
        return null;
    }

    @Override
    public void update(Song song) {

    }

    @Override
    public void remove(Song song) {

    }

    @Override
    public List<Song> findName(String name) {
        return null;
    }
}
