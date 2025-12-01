package lab5;

import java.util.*;

public class QueueOperations {
    // Задание 6.3: Проверить, есть ли элемент, равный следующему (по кругу)
    public static <T> boolean hasEqualNeighbors(Queue<T> queue) {
        if (queue.isEmpty() || queue.size() == 1) {
            return false;
        }
        // Преобразуем очередь в список для доступа по индексу
        List<T> list = new ArrayList<>(queue);
        int size = list.size();

        for (int i = 0; i < size; i++) {
            T current = list.get(i);
            // Следующий элемент (последний элемент сравнивается с первым)
            T next = list.get((i + 1) % size);

            if (current.equals(next)) {
                return true;
            }
        }

        return false;
    }

}