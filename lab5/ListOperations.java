package lab5;

import java.util.*;

public class ListOperations {
    // Задание 3.6: В списке из каждой группы подряд идущих одинаковых элементов оставить только один
    public static <T> void removeConsecutiveDuplicates(List<T> list) {
        if (list.isEmpty()) return;

        List<T> result = new ArrayList<>(); // Берем первый элемент
        T current = list.get(0);
        result.add(current);

        for (int i = 1; i < list.size(); i++) {
            // Сравниваем текущий элемент с предыдущим
            if (!list.get(i).equals(current)) { // equals - сравнение содержимого
                current = list.get(i);
                result.add(current);
            }
        }

        list.clear();
        list.addAll(result); // Заполняем элементами без дубликатов
    }
}