package lab5;

public class Funs {
    // meowables - массив с любым количеством вргументов Meowable
    public static void meowsCare(Meowable... meowables) {
        for (Meowable meowable : meowables) {
            for (int i = 0; i < 4; i++) {
                meowable.meow();
            }
        }
    }
}