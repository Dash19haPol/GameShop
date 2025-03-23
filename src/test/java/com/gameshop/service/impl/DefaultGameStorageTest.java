package com.gameshop.service.impl;

import com.gameshop.dao.GameStorageDao;
import com.gameshop.model.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class DefaultGameStorageTest {
    public static final String NAME = "name";
    public static final String TYPE = "name";
    public static final Float PRICE = 100.0f;

    @Mock
    private GameStorageDao gameStorageDao;

    @InjectMocks
    private DefaultGameStorage gameStorage;

    private Game game;
    private List<Game> games;

    @BeforeEach
    void setUp() {
        game = new Game(NAME, LocalDate.now(), 10f, PRICE, "description", TYPE);
        games = List.of(game);
    }

    @Test
    public void shouldAddGame() {
        gameStorage.add(game);

        verify(gameStorageDao).add(game);
    }

    @Test
    public void shouldDeleteGameById() {
        Integer gameId = 1;

        gameStorage.delete(gameId);

        verify(gameStorageDao).delete(gameId);
    }

    @Test
    public void shouldFindGameByName() {
        when(gameStorageDao.findByName(NAME)).thenReturn(game);

        Game foundGame = gameStorage.findByName(NAME);

        assertEquals(game, foundGame);
    }

    @Test
    public void shouldFindGameByPrice() {
        when(gameStorageDao.findByPrice(PRICE)).thenReturn(games);

        List<Game> foundGames = gameStorage.findByPrice(PRICE);

        assertEquals(games, foundGames);
    }

    @Test
    public void shouldFindGameByType() {
        when(gameStorageDao.findByType(TYPE)).thenReturn(games);

        List<Game> foundGames = gameStorage.findByType(TYPE);

        assertEquals(games, foundGames);
    }

    @Test
    public void shouldFindAllGamesSortedByAddData() {
        when(gameStorageDao.findAllSortedByAddData()).thenReturn(games);

        List<Game> foundGames = gameStorage.findAllSortedByAddData();

        assertEquals(games, foundGames);
    }

    @Test
    public void shouldFindAllGames() {
        when(gameStorageDao.findAll()).thenReturn(games);

        List<Game> foundGames = gameStorage.findAll();

        assertEquals(games, foundGames);
    }
}