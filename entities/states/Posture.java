package entities.states;

// Поза, в которой человек находится
public enum Posture {
    LYING("лежит"),
    SITTING("сидит"),
    STANDING("стоит"),
    HANGING("висит"),
    HANGING_UPSIDE_DOWN("висит вниз головой");

    private String postureName;
    Posture(String postureName) {
        this.postureName = postureName;
    }

    public String getName() {
        return postureName;
    }
}
