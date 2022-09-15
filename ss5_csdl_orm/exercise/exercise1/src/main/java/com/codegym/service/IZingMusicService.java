package com.codegym.service;

import com.codegym.model.ZingMusic;

import java.util.List;

public interface IZingMusicService {
    List<ZingMusic> findAll();

    void save(ZingMusic zingMusic);

    ZingMusic findById(int id);

    void update(ZingMusic zingMusic);

    void remove(int id);

    List<ZingMusic> findByName(String name);
}
