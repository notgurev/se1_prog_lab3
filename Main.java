import entities.*;
import entities.states.*;
import javafx.geometry.Pos;

public class Main {
    public static void main(String[] args) {
        AirBalloon balloon = new AirBalloon(0, 0, null, 1000, 110, 3000);
        Human Toropyzhka = new Human("Торопыжка", 1, 1, balloon, 35, Mood.WORRIED, Posture.STANDING, true);
        Human Znayka = new Human("Знайка", 3, 2, balloon, 200, Mood.CALM, Posture.STANDING, false);
        Human Neznayka = new Human("Незнайка", 4, 2, balloon, 32, Mood.PANIC, Posture.LYING, false);
        Human UnknownShorty = new Human("неизвестный коротышка", 1, 0, balloon, 40, Mood.CALM, Posture.STANDING, false);
        Human Vorchun = new Human("Ворчун", 0 , 0, balloon, 35, Mood.WORRIED, Posture.SITTING, false);
        Human Tubik = new Human("Тюбик", 0,0, balloon, 40, Mood.PANIC, Posture.SITTING, false);
        SandBag sandBag1 = new SandBag(null, null, balloon, 7);
        SandBag sandBag2 = new SandBag(null, null, balloon, 7);
        SandBag sandBag3 = new SandBag(null, null, balloon, 5);
        Parachute parachute1 = new Parachute(null, null, Toropyzhka, 5, false);
        Parachute parachute2 = new Parachute(null, null, Znayka, 5, false);
        Parachute parachute3 = new Parachute(null, null, Neznayka, 5, false);

        // Story
        Narrator.displayMap(balloon, 0, 0, 3);
        balloon.changeTemp(-3);
        balloon.coverInFrost();
        for (int i = 0; i <= 2; i++) {
            balloon.changeTemp(-10);
            balloon.moveVertically();
            Znayka.removeItemFromEntity(balloon, "SandBag", 1);
        }
        Znayka.move(Neznayka, 3, 3);
        Neznayka.setPosture(Posture.STANDING);
        Neznayka.setMood(Mood.WORRIED);
        Znayka.move(3, 0);
        Znayka.jumpOut(parachute1);
        Toropyzhka.jumpOut(parachute2);
        Toropyzhka.tryToUnhook(3, parachute2);
        Neznayka.moveWithPartner(UnknownShorty, Toropyzhka, 2, 0);
        balloon.moveVertically();
        Neznayka.say("Нам не удалось подобрать значения констант, чтобы красиво вычислялась скорость, но в целом все работает!");
    }
}
