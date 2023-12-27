package homeworkseven;


import java.util.NoSuchElementException;
import java.util.stream.Stream;

public class Fibonacci {
    public void fibonacciReduce() {
        int n = 5; // N-е число Фібоначчі, що треба вирахувати

        try {
            int fibN = Stream.iterate(new int[]{0, 1}, f -> new int[]{f[1], f[0] + f[1]})
                    .limit(n)
                    .reduce((a, b) -> b) // Отримання останньої пари
                    .orElseThrow() // Виключення якщо Optional is empty
                    [0]; // отримання числа Фібоначчі

            System.out.println(fibN);
        } catch (NoSuchElementException e) {
            System.out.println("Помилка при підрахуванні числа Фібоначчі: " + e.getMessage());
        }
    }
}
