package lab5;

import java.util.*; // Импорт классов для работы с коллекциями (Set, TreeSet)
import java.io.*;  // Импорт классов для ввода-вывода (InputStream)

public class DigitAnalyzer {
    public static void findDigitsInText(String filename) {
        // TreeSet для хранения уникальных цифр в отсортированном порядке
        // Set<Character> digits коллекция для хранения уникальных символов-цифр.
        Set<Character> digits = new TreeSet<>();

        try {
            // Чтение файла из того же пакета, InputStream читает байты:
            InputStream inputStream = DigitAnalyzer.class.getResourceAsStream(filename);

            if (inputStream == null) {
                System.out.println("Файл " + filename + " не найден в пакете lab5!");
                return;
            }

            Scanner scanner = new Scanner(inputStream);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (char c : line.toCharArray()) {
                    if (Character.isDigit(c)) {
                        digits.add(c);
                    }
                }
            }
            scanner.close();

            if (digits.isEmpty()) {
                System.out.println("В тексте не найдено цифр");
            } else {
                System.out.println("Цифры, встречающиеся в тексте:");
                for (char digit : digits) {
                    System.out.print(digit + " ");
                }
                System.out.println();
            }
        } catch (Exception e) {
            System.out.println("Ошибка чтения файла: " + e.getMessage());
        }
    }
}