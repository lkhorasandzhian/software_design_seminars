package org.example;

import software_design.game_industry.*;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameConsole gameConsole = new GameConsole("Play Station");

        List<Observer> people = Arrays.asList(
                new Gamer("Robert", 700, Seniority.BEGINNER),
                new Journalist("Julia", "Virtual Happiness", Seniority.AMATEUR),
                new Developer("Brian", "RPG", Seniority.PROFESSIONAL)
        );

        for (var person : people) {
            gameConsole.attachObserver(person);
        }

        gameConsole.notifyAllObservers();

        gameConsole.releaseGame(new Game(
                "GTA V",
                Arrays.asList("Welcome to Los Santos", "Crazy grandmas!", "San Andreas tourist"),
                "Best-seller developed by Rockstar Games in 2013" + System.lineSeparator(),
                "available on PS3 and PS4")
        );

        gameConsole.releaseGame(new Game(
                "The Last of Us",
                Arrays.asList("It can't be for nothing", "Something to fight for", "Look for the light"),
                "Action-adventure game developed by Naughty Dog in 2013" + System.lineSeparator(),
                "available on PS3 and PS4")
        );

        gameConsole.releaseGame(new Game(
                "Tom Clancy's Rainbow Six: Siege",
                Arrays.asList("Justified risk", "Commander in chief", "Death from above"),
                "Tactical shooter game developed by Ubisoft in 2015" + System.lineSeparator(),
                "available on PS4 and PS5")
        );
    }
}
