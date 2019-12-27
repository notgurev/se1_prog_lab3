package entities.states;

// Настроение человека
public enum Mood {
    CALM("спокоен"),
    WORRIED("немного тревожен"),
    PANIC("паникует");

    private String moodName;
    Mood(String moodName) {
        this.moodName = moodName;
    }

    public String getName() {
        return moodName;
    }
}
