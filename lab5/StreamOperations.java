package lab5;

import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class StreamOperations {

    public static void processPeopleFromFile() {
        String filename = "people.txt";

        try {
            // Чтение файла из того же пакета
            InputStream inputStream = StreamOperations.class.getResourceAsStream(filename);
            // Проверяем, найден ли файл
            if (inputStream == null) {
                System.out.println("Файл " + filename + " не найден в пакете lab5!");
                System.out.println("Создайте файл people.txt в папке lab5.");
                return;
            }
            // Читаем все строки файла в список
            List<String> fileLines = new ArrayList<>();
            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                fileLines.add(scanner.nextLine()); // Добавляем каждую строку в список
            }
            scanner.close();

            // Обработка данных с помощью Stream API
            Map<Integer, List<String>> result = fileLines.stream()
                    // Разделяем каждую строку по двоеточию на массив [имя, номер]
                    .map(line -> line.split(":"))
                    // Фильтруем: оставляем только строки с двумя частями и непустым номером
                    .filter(parts -> parts.length == 2 && !parts[1].isEmpty())
                    // Группируем по номеру, преобразуя имена к правильному регистру
                    .collect(Collectors.groupingBy(
                            //Ключ-номер (преобразованный в int)
                            parts -> Integer.parseInt(parts[1]),
                            Collectors.mapping(
                                    // Значение - имя с правильным регистром
                                    parts -> capitalizeName(parts[0]),
                                    Collectors.toList() // Собираем в список
                            )
                    ));

            // Измененный формат вывода
            System.out.print("[");
            List<String> groups = new ArrayList<>();
            // Преобразуем каждую группу в строку формата "номер:[имя1, имя2]"
            for (Map.Entry<Integer, List<String>> entry : result.entrySet()) {
                groups.add(entry.getKey() + ":[" + String.join(", ", entry.getValue()) + "]");
            }
            // Объединяем все группы через запятую
            System.out.print(String.join(", ", groups));
            System.out.println("]");

        } catch (Exception e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
    // метод для приведения имени к правильному регистру
    private static String capitalizeName(String name) {
        if (name == null || name.isEmpty()) return name;
        return name.substring(0, 1).toUpperCase() + name.substring(1).toLowerCase();
    }
}