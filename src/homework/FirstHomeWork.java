package homework;

public class FirstHomeWork {
    public static void main(String[] args) {
        int x = 10;
        int y = 7;
        if (x > y) {
            System.out.println(x + " > " + y);
        } else if (y > x) {
            System.out.println(y + " < " + x);
        } else {
            System.out.println(x + " = " + y);
        }

        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }

        int a = 5;
        int b = 7;
        int sum = a + b;
        System.out.println("a + b = " + sum);

        int n = 3;
        System.out.println("таблица умножения на " + n + ":");
        for (int i = 1; i <= 10; i++) {
            System.out.println(n + " * " + i + " = " + (n * i));
        }
    }
}