package com.gameshop.helper;

import com.gameshop.enums.Action;
import com.gameshop.model.Game;
import com.gameshop.service.GameStorage;
import com.gameshop.service.impl.DefaultGameStorage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Scanner;

public class UserInterfaceHelper {
    GameStorage gameStorage = new DefaultGameStorage();
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public boolean doAction(Scanner console) {
        System.out.print("select an action: ");
        String action = console.next();
        Action selectedAction = Action.valueOf(action);
        switch (selectedAction) {
            case ADD -> add(console);
            case DELETE -> {
                findAll();
                delete(console);
            }
            case SEARCH_BY_NAME -> findByName(console);
            case FILTER_BY_PRICE -> findByPrize(console);
            case FILTER_BY_TYPE -> findByType(console);
            case SHOW_ALL_SORTED -> findAllSortedByAddData();
            case SHOW_ALL -> findAll();
            case EXIT -> System.out.println("До побачення");
        }
        return selectedAction != Action.EXIT;
    }

    private void add(Scanner console) {
        System.out.print("Введіть назву гри: ");
        String name = console.next();
        System.out.print("Введіть дату випуску гри (ДД.ММ.ГГГГ): ");
        String releaseDateStr = console.next();
        LocalDate releaseDate = LocalDate.parse(releaseDateStr, dateTimeFormatter);
        System.out.print("Введіть рейтинг гри: ");
        Float rating = console.nextFloat();
        System.out.print("Введіть вартість гри: ");
        Float cost = console.nextFloat();
        System.out.print("Введіть опис гри: ");
        String description = console.next();
        System.out.print("Введіть тип гри: ");
        String type = console.next();

        Game game = new Game(name, releaseDate, rating, cost, description, type);
        gameStorage.add(game);
        System.out.println("Гру додано до БД");
    }

    private void delete(Scanner console) {
        System.out.print("Введіть id гри: ");
        Integer id = console.nextInt();
        gameStorage.delete(id);
        System.out.println("Гру видалено з БД");
    }

    private void findByName(Scanner console) {
        System.out.print("Введіть назву гри: ");
        String name = console.nextLine();
        Game game = gameStorage.findByName(name);
        System.out.println("ось ігри з такою назвою: " + game);

    }

    private void findByPrize(Scanner console) {
        System.out.print("Введіть вартість гри: ");
        Float cost = console.nextFloat();
        List<Game> games = gameStorage.findByPrice(cost);
        System.out.println("ось ігри з такою ціною: " + games);

    }

    private void findByType(Scanner console) {
        System.out.print("Введіть тип гри: ");
        String type = console.nextLine();
        List<Game> games = gameStorage.findByType(type);
        System.out.println("ось ігри з таким типом: " + games);
    }

    private void findAllSortedByAddData() {
        List<Game> games = gameStorage.findAllSortedByAddData();
        System.out.println("ось показ всіх ігор, відсортованих за датою додавання до бази даних: " + games );
    }

    private void findAll() {
        List<Game> games = gameStorage.findAll();
        System.out.println("ось всі доступні гри: " + games);
    }

}
