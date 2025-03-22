package com.gameshop.dao.impl;

import com.gameshop.dao.CommonDao;
import com.gameshop.model.Game;
import com.gameshop.dao.GameStorageDao;

import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


public class DefaultGameStorageDao extends CommonDao implements GameStorageDao {
    public static final String ADD_GAME = """
            INSERT INTO games (name, release_date, rating, cost, description, type)
            VALUES (?, ?, ?, ?, ?, ?)
            """;

    public static final String DELETE_GAME = "DELETE FROM games WHERE id = ?";


    public static final String FIND_BY_NAME_QUERY =
            "SELECT id, NAME, release_date, rating, cost, description, type, creation_date FROM games WHERE UPPER(NAME) = UPPER(?)";

    public static final String FIND_BY_NAME_PRIZE =
            "SELECT id, name,release_date, rating, description, type, creation_date FROM games WHERE cost = ?";

    public static final String FIND_BY_TYPE_QUERY =
            "SELECT id, name, release_date, rating, cost, description, creation_date FROM games WHERE UPPER(type) = UPPER(?)";

    public static final String FIND_ALL_QUERY =
            "SELECT id, name, release_date, rating, type, cost, description, creation_date FROM games";

    public static final String SORTED_BY_ADD_DATA_QUERY =
            "SELECT  id, name, release_date, rating, type, cost, description, creation_date FROM games ORDER BY creation_date DESC";


    @Override
    public void add(Game game) {
        Connection conn = getConnection();
        try (PreparedStatement pst = conn.prepareStatement(ADD_GAME)) {
            pst.setString(1, game.getName());
            pst.setDate(2, java.sql.Date.valueOf(game.getReleaseDate()));
            pst.setFloat(3, game.getRating());
            pst.setFloat(4, game.getCost());
            pst.setString(5, game.getDescription());
            pst.setString(6, game.getType());
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Integer id) {
        Connection conn = getConnection();
        try (PreparedStatement pst = conn.prepareStatement(DELETE_GAME)) {
            pst.setInt(1, id);
            pst.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Game findByName(String name) {
        Game game = null;
        Connection conn = getConnection();
        try (PreparedStatement pst = conn.prepareStatement(FIND_BY_NAME_QUERY)) {
            pst.setString(1, name);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                LocalDate releaseDate = resultSet.getDate("release_date").toLocalDate();
                Float rating = resultSet.getFloat("rating");
                Float cost = resultSet.getFloat("cost");
                String description = resultSet.getString("description");
                String type = resultSet.getString("type");
                LocalDateTime creationDate = resultSet.getTimestamp("creation_date").toLocalDateTime();
                game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return game;
    }


    @Override
    public List<Game> findByPrice(Float cost) {
        List<Game> games = new ArrayList<>();
        Connection conn = getConnection();
        try (PreparedStatement pst = conn.prepareStatement(FIND_BY_NAME_PRIZE)) {
            pst.setFloat(1, cost);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate releaseDate = resultSet.getDate("release_date").toLocalDate();
                Float rating = resultSet.getFloat("rating");
                String description = resultSet.getString("description");
                String type = resultSet.getString("type");
                LocalDateTime creationDate = resultSet.getTimestamp("creation_date").toLocalDateTime();
                Game game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> findByType(String type) {
        List<Game> games = new ArrayList<>();
        Connection conn = getConnection();
        try (PreparedStatement pst = conn.prepareStatement(FIND_BY_TYPE_QUERY)) {
            pst.setString(1, type);
            ResultSet resultSet = pst.executeQuery();
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate releaseDate = resultSet.getDate("release_date").toLocalDate();
                Float rating = resultSet.getFloat("rating");
                Float cost = resultSet.getFloat("cost");
                String description = resultSet.getString("description");
                LocalDateTime creationDate = resultSet.getTimestamp("creation_date").toLocalDateTime();
                Game game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> findAllSortedByAddData() {
        List<Game> games = new ArrayList<>();
        Connection conn = getConnection();
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(SORTED_BY_ADD_DATA_QUERY);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate releaseDate = resultSet.getDate("release_date").toLocalDate();
                Float rating = resultSet.getFloat("rating");
                String type = resultSet.getString("type");
                Float cost = resultSet.getFloat("cost");
                String description = resultSet.getString("description");
                LocalDateTime creationDate = resultSet.getTimestamp("creation_date").toLocalDateTime();
                Game game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }

    @Override
    public List<Game> findAll() {
        List<Game> games = new ArrayList<>();
        Connection conn = getConnection();
        try (Statement statement = conn.createStatement()) {
            ResultSet resultSet = statement.executeQuery(FIND_ALL_QUERY);
            while (resultSet.next()) {
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                LocalDate releaseDate = resultSet.getDate("release_date").toLocalDate();
                Float rating = resultSet.getFloat("rating");
                String type = resultSet.getString("type");
                Float cost = resultSet.getFloat("cost");
                String description = resultSet.getString("description");
                LocalDateTime creationDate = resultSet.getTimestamp("creation_date").toLocalDateTime();
                Game game = new Game(id, name, releaseDate, rating, cost, description, type, creationDate);
                games.add(game);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return games;
    }
}
