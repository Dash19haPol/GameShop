package com.gameshop.service.impl;

import com.gameshop.dao.GameStorageDao;
import com.gameshop.dao.impl.DefaultGameStorageDao;
import com.gameshop.model.Game;
import com.gameshop.service.GameStorage;

import java.util.List;

public class DefaultGameStorage implements GameStorage {
    GameStorageDao gameStorageDao = new DefaultGameStorageDao();

    @Override
    public void add(Game game) {
        gameStorageDao.add(game);
    }

    @Override
    public void delete(Integer id) {
        gameStorageDao.delete(id);
    }

    @Override
    public Game findByName(String name) {
        return gameStorageDao.findByName(name);
    }

    @Override
    public List<Game> findByPrice(Float cost) {
        return gameStorageDao.findByPrice(cost);
    }

    @Override
    public List<Game> findByType(String type) {
        return gameStorageDao.findByType(type);
    }

    @Override
    public List<Game> findAllSortedByAddData() {
        return gameStorageDao.findAllSortedByAddData();
    }

    @Override
    public List<Game> findAll() {
        return gameStorageDao.findAll();
    }
}
