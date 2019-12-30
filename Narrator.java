import entities.*;

public class Narrator {
    private static final char FILLER = '░';

    // Объявление в консоль
    public static void announce(String announcement) {
        System.out.println(announcement);
    }

    // Строит в консоли карту инвентаря Entity
    public static void displayMap(Entity entity, int centerX, int centerY, int radius) {
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
            // Если есть x-координата, то сохраняем иконку в массив (со сдвигом из-за кастомного центра)
            if (entity.getInventory()[i].getPosition().getLocalX() != null) {
                map[entity.getInventory()[i].getPosition().getLocalX()-centerX]
                        [entity.getInventory()[i].getPosition().getLocalY()-centerY] =
                        entity.getInventory()[i].getIcon();
            }
        }
        // Рисуем верхний ряд
        System.out.print('╔');
        for (int i = 0; i < 2*(dimLength)+1; i++) {
            System.out.print('═');
        }
        System.out.println('╗');
        // Пробегаем по строчкам (Y)
        for (int y = 0; y < dimLength; y++) {
            // Рисуем стенку и пробел
            System.out.print('║');
            System.out.print(' ');
            // Пробегам по столбикам (X)
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
