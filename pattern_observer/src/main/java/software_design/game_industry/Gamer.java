package software_design.game_industry;

public record Gamer(String name, int competitionRating, Seniority seniority) implements Observer {
    @Override
    public void updateState(Game game) {
        System.out.printf("%s gamer %s(%d) says: " + System.lineSeparator(), seniority, name, competitionRating);
        System.out.printf("I'm going to gain some new experience in %s!" + System.lineSeparator(), game.title());

        if (game.achievements() == null || game.achievements().isEmpty()) {
            System.out.println("Unfortunately, the game hasn't any achievements to get...");
            return;
        }

        System.out.println("Here is the list of achievements:");
        for (var achievement : game.achievements()) {
            System.out.println(achievement);
        }
    }
}
