package proglab.entities;

// Интерфейс для энтити, способных перемещать других энтити
public interface Mover {
    // Двигать объект
    void move(Entity entity, int newX, int newY);
    // Двигаться самому
    void move(int newX, int newY);
}
