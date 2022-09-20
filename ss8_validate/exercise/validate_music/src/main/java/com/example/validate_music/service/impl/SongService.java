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
        return iSongRepository.findAll();
    }

    @Override
    public void save(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public Song findById(int id) {
        return iSongRepository.findById(id);
    }

    @Override
    public void update(Song song) {
        iSongRepository.save(song);
    }

    @Override
    public void remove(Song song) {
        iSongRepository.delete(song);
    }

    @Override
    public List<Song> findName(String name) {
        return iSongRepository.findBySongName(name);
    }
}
