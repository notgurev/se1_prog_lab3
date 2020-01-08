package proglab.story;

import proglab.entities.*;

public class Narrator {
    public static void displayMap(Entity entity, int radius, int centerX, int centerY) {
        int dimLength = 2*radius + 1; // считаем длину стороны

        class Map {
            private static final char FILLER = '░';

            private Character[][] map = new Character[dimLength][dimLength]; // Создаем двойной массив-карту символов

            private void fillMap() {
                // Заполним весь массив филлером
                for (int y = 0; y < dimLength; y++) {
                    for (int x = 0; x < dimLength; x++) {
                        map[x][y] = FILLER;
                    }
                }
                // Заполняем символами по объектам
                for (int i = 0; i <= entity.getTopIndex(); i++) {
                    Integer x = entity.getInventory()[i].getPosition().getLocalX();
                    Integer y = entity.getInventory()[i].getPosition().getLocalY();
                    // Если есть x-координата, то сохраняем иконку в массив
                    if (x != null && Math.abs(x - centerX) <= radius && Math.abs(y - centerY) <= radius) {
                        map[x + radius - centerX][y + radius - centerY] = entity.getInventory()[i].getIcon();
                    }
                }
            }
        }

        Map map = new Map();
        map.fillMap();

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
                if (map.map[x][y] != null) {
                    System.out.print(map.map[x][y]);
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
