package software_design.game_industry;

public interface Subject {
    void attachObserver(Observer observer);
    void detachObserver(Observer observer);
    void notifyAllObservers();
}
