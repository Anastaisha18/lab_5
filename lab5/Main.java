package lab5;

import java.util.*;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n ЛАБОРАТОРНАЯ 5 ");
            System.out.println("1. Дробь с кэшированием");
            System.out.println("2. Кот и мяуканье");
            System.out.println("3. Удаление подряд идущих дубликатов");
            System.out.println("4. Анализ цен на сметану");
            System.out.println("5. Поиск цифр в тексте");
            System.out.println("6. Проверка соседних элементов в очереди");
            System.out.println("7.2 Обработка людей стримами");
            System.out.println("0. Выход");
            System.out.print("Выбор: ");

            String choice = scanner.nextLine();
            switch (choice) {
                case "1": task1(); break;
                case "2": task2(); break;
                case "3": task3(); break;
                case "4": task4(); break;
                case "5": task5(); break;
                case "6": task6(); break;
                case "7": task7(); break;
                case "0": return;
                default: System.out.println("Неверный выбор!");
            }
        }
    }

    private static void task1() {
        System.out.println("\n Дробь с кэшированием ");

        try {
            System.out.print("Введите числитель: ");
            int numerator = Integer.parseInt(scanner.nextLine());

            System.out.print("Введите знаменатель: ");
            int denominator = Integer.parseInt(scanner.nextLine());

            Fraction fraction = new Fraction(numerator, denominator);
            System.out.println("Обычная дробь: " + fraction);
            System.out.println("Её вещественное значение: " + fraction.getRealValue());

            CacheFract cacheFract = new CacheFract(numerator, denominator);
            System.out.println("\nКэшируемая дробь: " + cacheFract);
            System.out.println("Первый расчёт: " + cacheFract.getRealValue());
            System.out.println("Получение из кэша: " + cacheFract.getRealValue());

            System.out.println("\nИзменяем числитель на 9:");
            cacheFract.setNumerator(9);
            System.out.println("После изменения: " + cacheFract);
            System.out.println("Новое значение: " + cacheFract.getRealValue());

            System.out.println("\nСравнение дробей:");
            System.out.println("Исходная дробь: " + fraction);
            System.out.println("Измененная дробь: " + cacheFract);
            System.out.println("Результат сравнения: " + fraction.equals(cacheFract));

        } catch (NumberFormatException e) {
            System.out.println("Ошибка: введите целое число!");
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

    private static void task2() {
        System.out.println("\n Кот и мяуканье ");
        System.out.print("Имя кота: ");
        String name = scanner.nextLine();

        if (name.trim().isEmpty()) {
            System.out.println("Ошибка: имя не может быть пустым!");
            return;
        }

        Cat cat = new Cat(name);
        System.out.println("Создан: " + cat);

        Funs.meowsCare(cat);
        System.out.println("Кот мяукал " + cat.getMeowCount() + " раз");
    }

    private static void task3() {
        System.out.println("\n Удаление подряд идущих дубликатов ");
        System.out.print("Числа через пробел: ");
        String input = scanner.nextLine(); // Читаем строку с числами от пользователя

        try {
            List<Integer> list = new ArrayList<>();
            for (String s : input.split(" ")) {
                list.add(Integer.parseInt(s)); // Преобразуем каждую подстроку в число
            }

            System.out.println("До: " + list);
            ListOperations.removeConsecutiveDuplicates(list); // Удаляем дубликаты
            System.out.println("После: " + list);
        } catch (Exception e) {
            System.out.println("Ошибка ввода!");
        }
    }

    private static void task4() {
        System.out.println("\n Анализ цен на сметану ");
        SourCreamAnalyzer.analyze();
    }

    private static void task5() {
        System.out.println("\n Поиск цифр в тексте ");
        DigitAnalyzer.findDigitsInText("text_analysis.txt");
    }

    private static void task6() {
        System.out.println("\n Проверка соседних элементов в очереди ");
        System.out.print("Элементы очереди: ");
        String input = scanner.nextLine();

        try {
            // Создание очереди
            Queue<Integer> queue = new LinkedList<>();
            for (String s : input.split(" ")) {
                queue.add(Integer.parseInt(s));  // Преобразование строки в число
            }

            System.out.println("Очередь: " + queue);
            boolean result = QueueOperations.hasEqualNeighbors(queue);
            System.out.println("Соседние равные: " + result);
        } catch (Exception e) {
            System.out.println("Ошибка ввода!");
        }
    }

    private static void task7() {
            System.out.println("\n Обработка людей стримами ");
            System.out.println("Чтение из файла: people.txt (в пакете lab5)");
            StreamOperations.processPeopleFromFile();
        }
}