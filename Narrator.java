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
        char[][] map = new char[2*radius+1][2*radius+1];
        // Заполняем символами по объектам
        for (int i = 0; i < entity.getTopIndex(); i++) {
            // Если есть x-координата, то рисуем
            if (entity.getInventory()[i].getPosition().getLocalX() != null) {

            }
        }


        // Рисуем верхний ряд
        System.out.print('╔');
        for (int i = 0; i < dimLength; i++) {
            System.out.print('═');
        }
        System.out.println('╗');
        // Пробегаем по строчкам
        // Рисуем нижний ряд
        System.out.print('╚');
        for (int i = 0; i < dimLength; i++) {
            System.out.print('═');
        }
        System.out.print('╝');

    }
}
