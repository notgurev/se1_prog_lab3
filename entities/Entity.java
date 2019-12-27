package entities;

// Существо, имеющее массу, Position и инвентарь
public abstract class Entity implements GeneralMethods {
    private Position position; // позиция
    private int mass; // масса
    private final int INVENTORY_SIZE = 20; // размер инвентаря
    private Entity[] inventory; // инвентарь, хранящий Entity
    private int topIndex = -1; // индекс последнего Entity в инвентаре

    // Конструктор с вводом координат, владельца и массы. Можно ввести null.
    public Entity(Integer x, Integer y, Entity owner, int mass) {
        inventory = new Entity[INVENTORY_SIZE];
        position = new Position();
        this.mass = mass;
        position.setLocalX(x);
        position.setLocalY(y);
        position.setOwner(owner);
        if (owner != null) {
            owner.addItem(this);
        }
    }

    // Геттер для полной массы (включая весь инвентарь рекурсивно)
    public int getTotalMass() {
        int totalMass = getMass();
        if (topIndex != -1){
            for (int i = 0; i <= topIndex; i++){
                totalMass += inventory[i].getTotalMass();
            }
        }
        return totalMass;
    }

    // Геттер для массы данного существа без инвентаря
    public int getMass() {
        return mass;
    }

    // Удаление конкретного объекта Entity из инвентаря
    public void deleteItem(Entity entity) {
        int indexItem = -1;
        for ( int i = 0 ; i <= topIndex; i++){
            if (entity.equals(inventory[i])){
                indexItem = i;
                break;
            }
        }
        if (indexItem != -1) {
            for (int i = indexItem ; i <= topIndex - 1; i++){ inventory[i] = inventory[i + 1]; }
            topIndex -=1;
        }
    }
    // Удаление number первых попавшихся Entity c классом typeName
    public void deleteItem(String typeName, int number) {
        while (number > 0) {
            int indexItem = -1;
            for (int i = 0; i <= topIndex; i++) {
                if (this.inventory[i].toString().equals(typeName)) {
                    indexItem = i;
                    break;
                }
            }
            if (indexItem != -1) {
                for (int i = indexItem; i <= topIndex - 1; i++) { inventory[i] = inventory[i + 1]; }
                topIndex -= 1;
                number -= 1;
            } else { break;}
        }
    }

    // Добавление Entity в инвентарь
    public void addItem(Entity entity) {
        topIndex +=1;
        inventory[topIndex] = entity;
    }

    // Геттер Position
    public Position getPosition() {
        return position;
    }

    // Сеттеры для локальных координат и владельца в Position
    public void setCoordinates(int newX, int newY) {
        this.position.setLocalX(newX);
        this.position.setLocalY(newY);
    }
    public void setOwner(Entity newOwner) {
        this.position.setOwner(newOwner);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    // equals для простейших предметов, не имеющих новых полей
    @Override
    public boolean equals(Object o) {
        if (this == o) return true; // проверка ссылки на самого себя
        if (o == null || getClass() != o.getClass()) return false; // одного ли они класса или null
        return (getMass() == ((Entity) o).getMass()); // считаем, что Entity с одной массой равны
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}
