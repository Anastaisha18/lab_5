package lab5;

public class Cat implements Meowable {
    private String name; // Имя кота
    private int meowCount; // Счетчик мяуканий

    public Cat(String name) {
        // убираем пробелы и проверяем на пустоту
        if (name.trim().isEmpty()) throw new IllegalArgumentException("Имя не может быть пустым");
        this.name = name;
    }
    @Override public String toString() { return "кот: " + name; }

    @Override
    public void meow() {
        meowCount++;
        System.out.println(name + ": мяу!");
    }
    // Геттер для получения количества мяуканий
    public int getMeowCount() { return meowCount; }

}