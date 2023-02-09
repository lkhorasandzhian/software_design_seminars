package software_design.game_industry;

public record Developer(String name, String genre, Seniority seniority) implements Observer {
    @Override
    public void updateState(Game game) {
        System.out.printf("%s %s-developer %s says: " + System.lineSeparator(), seniority, genre, name);
        System.out.println("I guess all the newcomers are interested in technical data! Let's start:");
        System.out.println(game.technicalData());
    }
}
