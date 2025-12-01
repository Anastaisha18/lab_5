package lab5;

import java.util.*;
import java.io.*;

public class SourCreamAnalyzer {
    public static void analyze() {
        String filename = "lab5/shops.txt";

        try {
            // Ищем файл в папке проекта используем ClassLoader для доступа к ресурсам
            InputStream inputStream = SourCreamAnalyzer.class.getClassLoader().getResourceAsStream(filename);

            if (inputStream == null) {
                System.out.println("Ошибка: файл " + filename + " не найден в resources!");
                System.out.println("Проверьте что файл находится в: src/main/resources/lab5/shops.txt");
                return;
            }

            Scanner fileScanner = new Scanner(inputStream);
            // читаем первую строку(кол-во магазинов)
            int n = Integer.parseInt(fileScanner.nextLine().trim());

            // Инициализируем максимальным значением, чтобы любая реальная цена была меньше
            int min15 = Integer.MAX_VALUE, min20 = Integer.MAX_VALUE, min25 = Integer.MAX_VALUE;

            // Счетчики магазинов с минимальной ценой
            int count15 = 0, count20 = 0, count25 = 0;

            for (int i = 0; i < n; i++) {
                String line = fileScanner.nextLine();

                // Выводим строку
                System.out.println("  " + line);

                // Формат: [название_магазина] [страна] [жирность] [цена]
                String[] data = line.split(" ");

                // Извлекаем жирность сметаны (индекс 2)
                int fat = Integer.parseInt(data[2]);
                // Извлекаем цену ( индекс 3)
                int price = Integer.parseInt(data[3]);

                if (fat == 15) {
                    if (price < min15) {
                        min15 = price;
                        count15 = 1;
                    } else if (price == min15) {
                        count15++;
                    }
                } else if (fat == 20) {
                    if (price < min20) {
                        min20 = price;
                        count20 = 1;
                    } else if (price == min20) {
                        count20++;
                    }
                } else if (fat == 25) {
                    if (price < min25) {
                        min25 = price;
                        count25 = 1;
                    } else if (price == min25) {
                        count25++;
                    }
                }
            }
            // Закрываем сканер (освобождаем ресурсы)
            fileScanner.close();

            // Если для какой-то жирности не нашли цену то обнуляем счетчик
            if (min15 == Integer.MAX_VALUE) count15 = 0;
            if (min20 == Integer.MAX_VALUE) count20 = 0;
            if (min25 == Integer.MAX_VALUE) count25 = 0;

            System.out.println("\nРезультат: " + count15 + " " + count20 + " " + count25);

        } catch (Exception e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
            e.printStackTrace();
        }
    }
}