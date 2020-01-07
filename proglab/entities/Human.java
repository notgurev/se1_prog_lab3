package proglab.entities;
import proglab.entities.states.*;
import proglab.entities.traits.Intelligence;

public class Human extends Entity implements Mover {
    private String name; // имя
    private Mood mood; // настроение
    private Posture posture; // поза
    private Intelligence intelligence; // интеллект
    private char icon = 'h';

    public Human(String name, Integer x, Integer y, Entity owner, int mass, Mood mood, Posture posture, Intelligence intelligence) {
        super(x, y, owner, mass);
        this.name = name;
        this.mood = mood;
        this.posture = posture;
        this.intelligence = intelligence;
    }

    public String getName() {
        return name;
    }

    public Mood getMood() {
        return mood;
    }

    public Posture getPosture() {
        return posture;
    }

    public void setMood(Mood mood) {
        this.mood = mood;
        System.out.println(this.toString() + " теперь " + mood.getName());
    }

    public void setPosture(Posture posture) {
        this.posture = posture;
        System.out.println(this.toString() + " теперь " + posture.getName());
    }

    @Override
    public void move(Entity entity, int newX, int newY) {
        entity.setCoordinates(newX, newY);
        System.out.println(this.toString() + " передвинул " + entity.toString() + " на координаты x = " + newX + ", y = " + newY);
    }

    @Override
    public void move(int newX, int newY) {
        this.setCoordinates(newX, newY);
        System.out.println(this.toString() + " переместился на координаты x = " + newX + ", y = " + newY);
    }

    public void moveWithPartner(Human partner, Entity entity, int newX, int newY) {
        entity.setCoordinates(newX, newY);
        System.out.println(this.toString() + " и " + partner.toString() + " передвинули " + entity.toString() + " на координаты x = " + newX + ", y = " + newY);
    }

    // Удаляет вещь из инвентаря (не обязательно своего) по названию
    public void removeItemFromEntity(Entity owner, String itemName, int numberOfItems) {
        owner.deleteItem(itemName, numberOfItems);
        System.out.println(this.toString() + " удалил " + numberOfItems + " " + itemName + " из инвентаря " + owner.toString());
    }
    public void removeItemFromEntity(Entity owner, Entity item) {
        owner.deleteItem(item);
        System.out.println(this.toString() + " удалил " + item.toString() + " из инвентаря " + owner.toString());
    }
    // Что-то сказать
    public void say(String phrase) {
        System.out.println(this.toString() + " говорит: \"" + phrase +"\"");
    }

    // Прыгнуть из owner c парашютом
    public void jumpOut(Parachute parachute) {
        // Если человек глупый, то он сначала открывает парашют
        if (this.intelligence.ordinal() < Intelligence.ORDINARY.ordinal()) {
            parachute.openParachute();
            System.out.println(this.toString() + " открыл " + parachute.toString());
        }
        // Если парашют не открыт, то он нормально выпрыгивает
        if (!parachute.isOpen()) {
            System.out.println(name + " выпрыгивает из " + this.getPosition().getOwner().toString());
            // удаляет себя из инвентаря владельца
            this.getPosition().getOwner().deleteItem(this);
            // Потом открывает парашют
            parachute.openParachute();
            System.out.println(name + " открывает " + parachute.toString());
        } else {
            // Если открыт, то зацепляется
            parachute.hook();
            posture = Posture.HANGING_UPSIDE_DOWN;
            System.out.println(this.toString() + " запутался и теперь " + posture.getName());
        }

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        return (name.equals(((Human) o).name)); // у всех людей должны быть разные имена
    }

    @Override
    public String toString() {
        return name;
    }

    // Попробовать отцепить парашют
    public void tryToUnhook(int time, Parachute parachute) {
        for (int i = 0; i < time; i++) {
            if (parachute.getHookDurability() > 0) {
                parachute.changeHookDurability(- (int) Math.round(Math.random())*5);
            } else {
                parachute.unHook();
                System.out.println(name + " отцепил " + parachute.toString());
                break;
            }
        }
        System.out.println(name + " пытался отцепить " + parachute.toString() + " " + time + " секунд(ы)");
    }

    public void lookAt(Entity entity) {
        System.out.println(this.toString() + " смотрит на " + entity.toString());
    }

    public void look(String where) {
        System.out.println(this.toString() + " смотрит " + where);
    }

    public void announceMood() {
        System.out.println(this.toString() + " " + this.mood.getName());
    }

     public class Argument {
        private Human partner;
        public Argument(Human partner) {
            this.partner = partner;
        }

        public void start() {
            System.out.println(name + " начал спорить с " + partner.toString());
        }
    }
}
