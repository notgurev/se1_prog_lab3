package proglab.story;

import proglab.entities.*;

public class Narrator {
    public static final char FILLER = '░';

    // Объявление в консоль
    public static void announce(String announcement) {
        System.out.println(announcement);
    }

    // Строит в консоли карту инвентаря Entity
    public static void displayMap(Entity entity, int radius) {
        // Высчитываем количество ячеек
        /*
        Пример:
        ╔═══════════════╗
        ║ T U ░ ░ ░ ░ ░ ║
        ║ ░ R ░ ░ ░ ░ ░ ║
        ║ ░ ░ ░ Z N ░ ░ ║
        ║ ░ ░ ░ ░ ░ ░ ░ ║
        ║ ░ ░ ░ ░ ░ ░ ░ ║
        ║ ░ ░ ░ ░ ░ ░ ░ ║
        ║ ░ ░ ░ ░ ░ ░ ░ ║
        ╚═══════════════╝
         */
        int dimLength = 2*radius + 1;
        // Создаем двойной массив-карту символов
        Character[][] map = new Character[dimLength][dimLength];
        // Заполняем символами по объектам
        for (int i = 0; i < entity.getTopIndex(); i++) {
            Integer x = entity.getInventory()[i].getPosition().getLocalX();
            Integer y = entity.getInventory()[i].getPosition().getLocalY();
            // Если есть x-координата, то сохраняем иконку в массив
            if (x != null && x <= radius && y <= radius) {
                map[x + radius][y + radius] = entity.getInventory()[i].getIcon();
            }
        }
        // Рисуем верхний ряд
        System.out.print('╔');
        for (int i = 0; i < 2*(dimLength)+1; i++) {
            System.out.print('═');
        }
        System.out.println('╗');
        // Пробегаем по (X)
        for (int x = 0; x < dimLength; x++) {
            // Рисуем стенку и пробел
            System.out.print('║');
            System.out.print(' ');
            // Пробегам по (Y)
            for (int y = 0; y < dimLength; y++) {
                // Рисуем иконку, если что-то есть в ячейке, иначе рисуем филлер
                if (map[y][x] != null) {
                    System.out.print(map[y][x]);
                } else {
                    System.out.print(FILLER);
                }
                System.out.print(' ');
            }
            System.out.println('║');
        }
        // Рисуем нижний ряд
        System.out.print('╚');
        for (int i = 0; i < 2*(dimLength)+1; i++) {
            System.out.print('═');
        }
        System.out.println('╝');

    }
}
