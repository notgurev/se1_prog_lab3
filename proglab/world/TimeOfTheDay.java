package proglab.world;

public enum TimeOfTheDay {
    MORNING("Солнце поднимается с Востока"),
    AFTERNOON("Солнце ровно над головой"),
    EVENING("Солнце клонится к закату"),
    NIGHT("Тьма тьмущая");

    private String timeAnnouncement;
    TimeOfTheDay(String timeAnnouncement) {
        this.timeAnnouncement = timeAnnouncement;
    }

    public String announceTime() {
        return timeAnnouncement;
    }
}
