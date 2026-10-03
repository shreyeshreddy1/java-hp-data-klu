public class javaque  {
    public static void main(String[] args) {
        try (java.util.Scanner scanner = new java.util.Scanner(System.in)) {
            int m = scanner.nextInt(); 
            int result = factorial(m); 
            System.out.println("Factorial of " + m + " is: " + result);
        }
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
}
