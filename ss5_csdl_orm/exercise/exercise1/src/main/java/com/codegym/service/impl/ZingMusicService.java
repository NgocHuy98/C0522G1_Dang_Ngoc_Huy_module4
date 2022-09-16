package com.codegym.service.impl;

import com.codegym.model.ZingMusic;
import com.codegym.repository.IZingMusicRepository;
import com.codegym.service.IZingMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZingMusicService implements IZingMusicService {
    @Autowired
    IZingMusicRepository iZingMusicRepository;

    @Override
    public List<ZingMusic> findAll() {
        return iZingMusicRepository.findAll();
    }

    @Override
    public void save(ZingMusic zingMusic) {
        iZingMusicRepository.save(zingMusic);
    }

    @Override
    public ZingMusic findById(int id) {
        return iZingMusicRepository.findById(id);
    }

    @Override
    public void update(ZingMusic zingMusic) {
        iZingMusicRepository.update(zingMusic);
    }

    @Override
    public void remove(int id) {
        iZingMusicRepository.remove(id);
    }

    @Override
    public List<ZingMusic> findByName(String name) {
        return iZingMusicRepository.findByName(name);
    }

}
