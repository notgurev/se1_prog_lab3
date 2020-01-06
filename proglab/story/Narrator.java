package proglab.story;

import proglab.entities.*;

public class Narrator {
    public static final char FILLER = '░';

    // Объявление в консоль
    public static void announce(String announcement) {
        System.out.println(announcement);
    }

    // Строит в консоли карту инвентаря Entity
    public static void displayMap(Entity entity, int radius, int centerX, int centerY) {
        // Высчитываем количество ячеек
        /*
        Пример:
        ╔═══════════════╗ x ->
        ║ T U ░ ░ ░ ░ ░ ║ y
        ║ ░ R ░ ░ ░ ░ ░ ║ |
        ║ ░ ░ ░ Z N ░ ░ ║ |
        ║ ░ ░ ░ ░ ░ ░ ░ ║ V
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
            if (x != null && Math.abs(x - centerX) <= radius && Math.abs(y - centerY) <= radius) {
                map[x + radius - centerX][y + radius - centerY] = entity.getInventory()[i].getIcon();
            }
        }
        // Рисуем верхний ряд
        System.out.print('╔');
        for (int i = 0; i < 2*(dimLength)+1; i++) {
            System.out.print('═');
        }
        System.out.println('╗');
        // Пробегаем по (Y)
        for (int y = 0; y < dimLength; y++) {
            // Рисуем стенку и пробел
            System.out.print('║');
            System.out.print(' ');
            // Пробегам по (X)
            for (int x = 0; x < dimLength; x++) {
                // Рисуем иконку, если что-то есть в ячейке, иначе рисуем филлер
                if (map[x][y] != null) {
                    System.out.print(map[x][y]);
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
