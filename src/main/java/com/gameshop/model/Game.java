package com.gameshop.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class Game {
    private Integer id;
    private String name;
    private LocalDate releaseDate;
    private Float rating;
    private Float cost;
    private String description;
    private String type;
    private LocalDateTime creationDate;

    public Game(String name, LocalDate releaseDate, Float rating, Float cost, String description, String type) {
        this.name = name;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.cost = cost;
        this.description = description;
        this.type = type;
    }

    @Override
    public String toString() {
        String ls = System.lineSeparator();
        return String.format("%s%sid:           %d%s", ls, ls, id, ls) +
               String.format("Назва:        %s%s", name, ls) +
               String.format("Дата випуску: %s%s", releaseDate, ls) +
               String.format("Рейтинг:      %.1f%s", rating, ls) +
               String.format("Вартість:     $%.2f%s", cost, ls) +
               String.format("Жанр:         %s%s", type, ls) +
               String.format("Опис:         %s%s", description, ls) +
               String.format("Додано:       %s%s", creationDate.toString(), ls);
    }
}
