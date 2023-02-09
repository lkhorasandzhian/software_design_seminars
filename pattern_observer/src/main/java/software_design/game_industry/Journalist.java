package software_design.game_industry;

public record Journalist(String name, String printShop, Seniority seniority) implements Observer {
    @Override
    public void updateState(Game game) {
        System.out.printf("%s journalist %s from %s says: " + System.lineSeparator(), seniority, name, printShop);
        System.out.println("My colleges got some info about the game! Here it is:");
        System.out.println(game.info());
    }
}
