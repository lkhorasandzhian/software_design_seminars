package software_design.game_industry;

import java.util.List;

public record Game(String title, List<String> achievements, String info, String technicalData) {
    @Override
    public int hashCode() {
        return title.hashCode();
    }
}
