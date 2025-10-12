package homework5;

public class BraceCheckerTest {
        public static void main(String[] args) {
            BraceChecker bc1 = new BraceChecker("Hello from [Java]");
            bc1.check();
            System.out.println("------");
            BraceChecker bc2 = new BraceChecker("Hello from [Java)");
            bc2.check();
            System.out.println("------");
        }
    }


