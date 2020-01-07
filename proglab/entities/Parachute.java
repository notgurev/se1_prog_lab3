package proglab.entities;

public class Parachute extends Entity {
    private boolean isOpen; // открыт ли
    private boolean hooked; // зацепился ли
    private char icon = 'p'; // иконка
    private Binding binding; // крепление

    // нестатический вложенный класс
    class Binding {
        private int durability = 100;

        public int getDurability() {
            return durability;
        }

        public void changeDurability(int durabilityChange) {
            this.durability += durabilityChange;
        }
    }

    public Parachute(Integer x, Integer y, Entity owner, int mass, boolean isOpen) {
        super(x, y, owner, mass);
        this.isOpen = isOpen;
        binding = new Binding();
    }

    public Binding getBinding() {
        return binding;
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
}
