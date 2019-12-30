import entities.*;

public class Narrator {
    // Объявление в консоль
    public static void announce(String announcement) {
        System.out.println(announcement);
    }

    // Строит в консоли карту инвентаря Entity
    public static void displayMap(Entity entity, int centerX, int centerY, int radius) {
        // Высчитываем количество ячеек
        /*
        ╔═════╗
        ║░░░░░║ радиус тут 2 -> длина стороны 5 = 2 * 2 + 1
        ║░░░░░║
        ║░░░░░║
        ╚═════╝
         */
        int dimLength = 2*radius + 1;
        // Создаем двойной массив-карту символов
        Character[][] map = new Character[2*radius+1][2*radius+1];
        // Заполняем символами по объектам
        for (int i = 0; i < entity.getTopIndex(); i++) {
            // Если есть x-координата, то сохраняем иконку в массив (со сдвигом из-за кастомного центра)
            if (entity.getInventory()[i].getPosition().getLocalX() != null) {
                map[entity.getInventory()[i].getPosition().getLocalX()-centerX]
                        [entity.getInventory()[i].getPosition().getLocalY()-centerY] =
                        entity.getInventory()[i].getIcon();
            }
        }
        // Рисуем верхний ряд
        System.out.print('╔');
        for (int i = 0; i < dimLength; i++) {
            System.out.print('═');
        }
        System.out.println('╗');
        // Пробегаем по строчкам (Y)
        for (int y = 1; y < dimLength; y++) {
            // Пробегам по столбикам (X)
            for (int x = 0; x < dimLength; x++) {
                // рисуем иконку, если что-то есть в ячейке
                if (map[x][y] != null)
            }
        }
        // Рисуем нижний ряд
        System.out.print('╚');
        for (int i = 0; i < dimLength; i++) {
            System.out.print('═');
        }
        System.out.print('╝');

    }
}
