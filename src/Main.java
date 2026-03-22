import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Task 1:");
        int number = scanner.nextInt();
        printDigits(number);
    }
    public static void printDigits(int n) {
        if (n > 9) {
            printDigits(n / 10);
        }
        System.out.println(n % 10);
    }
}
//*Task - 2
// public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Task 2:");
//        int n = scanner.nextInt();
//        System.out.println("elements");
//        double sum = getSum(scanner, n);
//        double average = sum / n;
//        System.out.println("Среднее значение: " + average);
//    }
//    public static double getSum(Scanner scanner, int n) {
//        if (n == 0) {
//            return 0;
//        }
//        double currentNumber = scanner.nextDouble();
//        return currentNumber + getSum(scanner, n - 1);
//    }
//}
// Task -3
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Task 3:");
//        int n = scanner.nextInt();
//        String result = isPrime(n, 2);
//        System.out.println(result);
//    }
//
//    public static String isPrime(int n, int divisor) {
//        if (n < 2) {
//            return "Composite";
//        }
//        if (n == 2) {
//            return "Prime";
//        }
//        if (n % divisor == 0) {
//            return "Composite";
//        }
//        if (divisor * divisor > n) {
//            return "Prime";
//        }
//        return isPrime(n, divisor + 1);
//    }
//}
//Task-4
//public class Main {
//
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Task 4:");
//        int n = scanner.nextInt();
//        int result = factorial(n);
//        System.out.println(result);
//    }
//    public static int factorial(int n) {
//        if (n <= 1) {
//            return 1;
//        }
//        return n * factorial(n - 1);
//    }
//}
// Task-5
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Task 5:");
//        int n = scanner.nextInt();
//
//        int result = fibonacci(n);
//        System.out.println(result);
//    }
//
//    public static int fibonacci(int n) {
//        if (n == 0) return 0;
//        if (n == 1) return 1;
//
//        return fibonacci(n - 1) + fibonacci(n - 2);
//    }
//}
//Task-6
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Task 6");
//        int a = scanner.nextInt();
//        System.out.println("Enter n :");
//        int n = scanner.nextInt();
//
//        int result = power(a, n);
//        System.out.println("Result: " + result);
//    }
//
//    public static int power(int a, int n) {
//        if (n == 0) {
//            return 1;
//        }
//        return a * power(a, n - 1);
//    }
//}
//Task-7
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("n");
//        int n = scanner.nextInt();
//        System.out.println("Enter:");
//
//        reverseOutput(scanner, n);
//        System.out.println();
//    }
//
//    public static void reverseOutput(Scanner scanner, int n) {
//        if (n == 0) {
//            return;
//        }
//        int currentNumber = scanner.nextInt();
//        reverseOutput(scanner, n - 1);
//        System.out.print(currentNumber + " ");
//    }
//}
//Task-8
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("row:");
//        String s = scanner.nextLine();
//
//        System.out.println(checkDigits(s));
//    }
//
//    public static String checkDigits(String s) {
//        if (s.isEmpty()) return "Yes";
//        if (!Character.isDigit(s.charAt(0))) return "No";
//
//        return checkDigits(s.substring(1));
//    }
//}
////Task - 9
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("row:");
//        String s = scanner.nextLine();
//
//        System.out.println("Symbol " + countCharacters(s));
//    }
//
//    public static int countCharacters(String s) {
//        if (s.isEmpty()) {
//            return 0;
//        }
//        return 1 + countCharacters(s.substring(1));
//    }
//}
//// Task - 10
//public class Main {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//        System.out.println("Enter number (a):");
//        int a = scanner.nextInt();
//        System.out.println("Enter number(b):");
//        int b = scanner.nextInt();
//        System.out.println("Greatest Common Divisor: " + gcd(a, b));
//    }
//    public static int gcd(int a, int b) {
//        if (b == 0) {
//            return a;
//        }
//        return gcd(b, a % b);
//    }
//}