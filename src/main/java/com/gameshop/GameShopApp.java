package com.gameshop;

import com.gameshop.enums.Action;
import com.gameshop.helper.UserInterfaceHelper;

import java.util.Arrays;
import java.util.Scanner;

public class GameShopApp {
    public static void main(String[] args) {
        GameShopApp gameShopApp = new GameShopApp();
        gameShopApp.run();
    }

    private void run() {
        showMenu();
        UserInterfaceHelper userInterfaceHelper = new UserInterfaceHelper();
        try (Scanner console = new Scanner(System.in)) {
            boolean isContinue;
            do {
                isContinue = userInterfaceHelper.doAction(console);
            }
            while (isContinue);
        }
    }

    private void showMenu() {
        System.out.println("Управління Іграми:");
        Arrays.stream(Action.values()).forEach(action -> {
            System.out.println(action.getActionItem());
        });
    }
}
