package com.gameshop.dao;

import com.gameshop.model.Game;

import java.util.List;

public interface GameStorageDao {
    void add(Game game);
    void delete(Integer id);
    Game findByName(String name);
    List<Game> findByPrice(Float rating);
    List<Game> findByType(String type);
    List<Game> findAllSortedByAddData();
    List<Game> findAll();
}
