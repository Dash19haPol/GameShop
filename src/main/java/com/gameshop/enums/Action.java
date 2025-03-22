package com.gameshop.enums;

public enum Action {
    ADD("Додавання нової гри"),
    DELETE("Видалення гри"),
    SEARCH_BY_NAME("Пошук гри за назвою"),
    FILTER_BY_PRICE("Фільтрація ігор за ціною"),
    FILTER_BY_TYPE("Фільтрація ігор за типом."),
    SHOW_ALL_SORTED("Показ всіх ігор, відсортованих за датою додавання до бази даних"),
    SHOW_ALL("Перегляд списку всіх доступних ігор"),
    EXIT("Вихід");

    private final String label;

    Action(String label) {
        this.label = label;
    }

    public String getActionItem() {
        return "* " + name() + " - " + label;
    }
}
