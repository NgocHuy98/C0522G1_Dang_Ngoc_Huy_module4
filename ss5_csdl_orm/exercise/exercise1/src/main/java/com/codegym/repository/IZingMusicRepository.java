package com.codegym.repository;

import com.codegym.model.ZingMusic;

import java.util.List;

public interface IZingMusicRepository {
    List<ZingMusic> findAll();

    void save(ZingMusic zingMusic);

    ZingMusic findById(int id);

    void update(ZingMusic zingMusic);

    void remove(int id);

    List<ZingMusic> findByName(String name);
}
