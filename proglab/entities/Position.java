package proglab.entities;

public class Position implements GeneralMethods {
    private Integer x, y; // координаты внутри владельца (например, внутри корзины воздушного шара)
    private Entity owner; // владелец существа, то есть тот, в чьем инвентаре оно находится

    public Position() {
        // пустой, так как параметры задаются при создании Entity
    }

    // Геттер локальных координат (внутри владельца)
    public Integer getLocalX() {
        return x;
    }
    public Integer getLocalY() {
        return y;
    }

    // Геттер владельца
    public Entity getOwner() {
        return owner;
    }

    // Геттер координат "главного" владельца
    public Integer getGlobalX() {
        if (owner != null) {
            return owner.getPosition().getGlobalX();
        } else {
            return x;
        }
    }
    public Integer getGlobalY() {
        if (owner != null) {
            return owner.getPosition().getGlobalY();
        } else {
            return y;
        }
    }

    // Смена владельца
    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    // Сеттер локальных координат
    public void setLocalX(Integer newX) {
        x = newX;
    }
    public void setLocalY(Integer newY) {
        y = newY;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Position pos = (Position) obj;
        return (pos.getLocalX() == x && pos.getLocalY() == y && pos.getOwner().equals(owner));
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
