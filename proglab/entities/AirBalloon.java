package proglab.entities;

public class AirBalloon extends Entity {
    private boolean isCoveredInFrost = false; // покрыт ли наледью
    private int temp, height; // температура, высота
    // Коэффициенты для вычисления скорости, значения случайные
    private static final int MASS_SPEED_COEFFICIENT = -1;
    private static final int ARCHIMEDES_FORCE = 14;
    private static final int ENV_TEMP = 10;
    private char icon = 'a';

    public AirBalloon(Integer x, Integer y, Entity owner, int mass, int temp, int height) {
        super(x, y, owner, mass);
        this.temp = temp;
        this.height = height;
    }

    // Изменение температуры на tempChange (+/-)
    public void changeTemp(int tempChange) {
        temp += tempChange;
        System.out.println("Температура " + this.toString() + " изменилась на " + tempChange + " и стала " + temp);
    }

    // Вычисление вертикальной скорости
    public int calculateVerticalSpeed() {
        return getTotalMass() * MASS_SPEED_COEFFICIENT + (temp - ENV_TEMP) * ARCHIMEDES_FORCE;
    }

    // Вертикальное перемещение в зависимости от вычисленной скорости
    public void moveVertically () {
        height += calculateVerticalSpeed();
        System.out.println("Высота " + this.toString() + " изменилась на " + calculateVerticalSpeed() + " и стала " + height);
    }

    public boolean isCoveredInFrost() {
        return isCoveredInFrost;
    }

    public void coverInFrost() {
        isCoveredInFrost = true;
        System.out.println(this.toString() + " покрылся инеем");
    }

    public void uncoverFromFrost() {
        isCoveredInFrost = false;
        System.out.println("Иней на " + this.toString() + " исчез");
    }
}
