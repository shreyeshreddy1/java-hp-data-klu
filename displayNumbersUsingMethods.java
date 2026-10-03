    import java.util.Scanner;

    public class displayNumbersUsingMethods {
        public static void our() {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter a number: ");
            int n = scanner.nextInt();

            for (int i = 1; i <= n; i++) {
                System.out.println(i);
            }

            for (int j = n; j >= 1; j--) {
                System.out.println(j);
            }
        }

        public static void main(String[] args) {
            our();
        }
    }
    