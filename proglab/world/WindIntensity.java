package proglab.world;

public enum WindIntensity {
    CALM("Ветра нет."),
    BREEZE("Дует легкий бриз."),
    MILD("Дует небольшой ветер."),
    STRONG("Дует сильный ветер."),
    STORM("Бушует шторм.");

    private String windIntensityAnnouncement;
    WindIntensity(String windIntensityAnnouncement) {
        this.windIntensityAnnouncement = windIntensityAnnouncement;
    }

    public String announceWindIntensity() {
        return windIntensityAnnouncement;
    }
}
