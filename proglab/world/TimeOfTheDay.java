package proglab.world;

public enum TimeOfTheDay {
    MORNING("Солнце поднимается с Востока"),
    AFTERNOON("Солнце стоит в зените"),
    EVENING("Солнце клонится к закату"),
    NIGHT("Тьма тьмущая");

    private String timeAnnouncement;
    TimeOfTheDay(String timeAnnouncement) {
        this.timeAnnouncement = timeAnnouncement;
    }

    public void announceTime() {
        System.out.println(timeAnnouncement);
    }
}
