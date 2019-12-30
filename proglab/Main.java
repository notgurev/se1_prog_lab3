package proglab;

import proglab.entities.*;
import proglab.entities.traits.*;
import proglab.story.*;

public class Main {
    public static void main(String[] args) {
        AirBalloon balloon = new AirBalloon(0, 0, null, 1000, 110, 3000);
        Human Toropyzhka = new Human("Торопыжка", 0, -1, balloon, 35, proglab.entities.states.Mood.WORRIED, proglab.entities.states.Posture.STANDING, Intelligence.DUMMY);
        Toropyzhka.setIcon('H');
        Human Znayka = new Human("Знайка", 1, 0, balloon, 200, proglab.entities.states.Mood.CALM, proglab.entities.states.Posture.STANDING, Intelligence.SMART);
        Znayka.setIcon('Z');
        Human Neznayka = new Human("Незнайка", 2, 0, balloon, 32, proglab.entities.states.Mood.PANIC, proglab.entities.states.Posture.LYING, Intelligence.ORDINARY);
        Neznayka.setIcon('N');
        Human UnknownShorty = new Human("неизвестный коротышка", -1, 2, balloon, 40, proglab.entities.states.Mood.CALM, proglab.entities.states.Posture.STANDING, Intelligence.ORDINARY);
        UnknownShorty.setIcon('U');
        Human Vorchun = new Human("Ворчун", -2 , 0, balloon, 35, proglab.entities.states.Mood.WORRIED, proglab.entities.states.Posture.SITTING, Intelligence.ORDINARY);
        Vorchun.setIcon('V');
        Human Tubik = new Human("Тюбик", 2,2, balloon, 40, proglab.entities.states.Mood.PANIC, proglab.entities.states.Posture.SITTING, Intelligence.ORDINARY);
        Tubik.setIcon('T');
        SandBag sandBag1 = new SandBag(null, null, balloon, 7);
        SandBag sandBag2 = new SandBag(null, null, balloon, 7);
        SandBag sandBag3 = new SandBag(null, null, balloon, 5);
        Parachute parachute1 = new Parachute(null, null, Toropyzhka, 5, false);
        Parachute parachute2 = new Parachute(null, null, Znayka, 5, false);
        Parachute parachute3 = new Parachute(null, null, Neznayka, 5, false);

        // Story
        Narrator.displayMap(balloon, 2, 0,0);
        balloon.changeTemp(-3);
        balloon.coverInFrost();
        for (int i = 0; i <= 2; i++) {
            balloon.changeTemp(-10);
            balloon.moveVertically();
            Znayka.removeItemFromEntity(balloon, "SandBag", 1);
        }
        Znayka.move(Neznayka, 1, 1);
        Narrator.displayMap(balloon, 2, 0,0);
        Neznayka.setPosture(proglab.entities.states.Posture.STANDING);
        Neznayka.setMood(proglab.entities.states.Mood.WORRIED);
        Znayka.move(2, 0);
        Narrator.displayMap(balloon, 2, 0,0);
        Znayka.jumpOut(parachute1);
        Narrator.displayMap(balloon, 2, 0,0);
        Toropyzhka.move(0,-2);
        Narrator.displayMap(balloon, 2, 0,0);
        Toropyzhka.move(0,-3);
        Toropyzhka.jumpOut(parachute2);
        Toropyzhka.tryToUnhook(3, parachute2);
        UnknownShorty.move(-1,-2);
        Neznayka.move(1,-2);
        Narrator.displayMap(balloon, 2, 0,0);
        Neznayka.moveWithPartner(UnknownShorty, Toropyzhka, 2, 0);
        Narrator.displayMap(balloon, 2, 0,0);
        balloon.moveVertically();
        Neznayka.say("Нам не удалось подобрать значения констант, чтобы красиво вычислялась скорость, но в целом все работает!");
    }
}
