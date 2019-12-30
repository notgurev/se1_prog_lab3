package proglab.structures;

/*
    Структура - особый элемент, предназначенный для наполнения и построения мира, в основном графического.
    Структуры, в отличие от Entity, не имеют инвентаря, массы, поэтому от него не наследуются.
    Структуры имеют Position, но x и y всегда равны null, а owner задается только при создании объекта.
    Структуры состоят из одной и более субструктур, которые имеют x и y.
    Отдельные структуры не могут быть перемещены, поэтому не имплементируют интерфейс Movable,
    однако они могут быть удалены из инвентаря.
    [не реализовано] "Единичные" структы, состоящие из 1 субструктуры, могут быть перемещены.
    Структуры при отрисовке имеют меньший приоритет, нежели Entity, но имеют свою иконку.
    Структуры имеют массив субструктур.
 */

import proglab.entities.*;
import proglab.story.Narrator;

public abstract class Structure {
    private Position position; // позиция
    private Character icon = Narrator.FILLER; // иконка по умолчанию


    public Structure(Entity owner) {
        position = new Position();
        position.setLocalX(null);
        position.setLocalY(null);
        //owner.addItem();
    }

    class SubStructure {

    }

    // Удалить структуру
    public void removeStructure() {

    }
}
