package proglab.entities;

public class Parachute extends Entity {
    private boolean isOpen; // открыт ли
    private boolean hooked; // зацепился ли
    private int hookDurability = 100; //прочность крепления
    private char icon = 'p';

    public Parachute(Integer x, Integer y, Entity owner, int mass, boolean isOpen) {
        super(x, y, owner, mass);
        this.isOpen = isOpen;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void openParachute() {
        isOpen = true;
    }

    public boolean isHooked() {
        return hooked;
    }

    public void hook() {
        this.hooked = true;
        System.out.println(this.toString() + " зацепился");
    }

    public void unHook() {
        this.hooked = false;
    }

    public int getHookDurability() {
        return hookDurability;
    }

    public void changeHookDurability(int hookDurabilityChange) {
        this.hookDurability += hookDurabilityChange;
    }
}
