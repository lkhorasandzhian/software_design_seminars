package software_design.game_industry;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GameConsole implements Subject {
    private final List<Observer> observers = new ArrayList<>();
    private final String company;
    private final Set<Game> games = new HashSet<>();
    private Game latestGame;

    public GameConsole(String company) {
        this.company = company;
    }

    public void releaseGame(Game game) {
        if (games.contains(game)) {
            System.out.printf("%s was already been released by %s" + System.lineSeparator(), game.title(), company);
            return;
        }

        games.add(game);
        latestGame = game;
        System.out.printf("%s has released a new game!" + System.lineSeparator(), company);
        notifyAllObservers();
    }

    @Override
    public void attachObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void detachObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyAllObservers() {
        if (latestGame == null) {
            System.out.println("There is no data about the latest game!" + System.lineSeparator());
            return;
        }

        for (Observer observer : observers) {
            observer.updateState(latestGame);
            System.out.println();
        }
    }
}
