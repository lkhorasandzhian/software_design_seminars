package software_design.game_industry;

public interface Subject {
    void attachObserver();
    void detachObserver();
    void notifyObservers();
}
