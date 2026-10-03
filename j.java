import java.util.Scanner;

class ArithmeticOperations {

    public void add(int a, int b) {
        System.out.println("Addition: " + (a + b));
    }

    public void sub(int a, int b) {
        System.out.println("Subtraction: " + (a - b));
    }

    public void mul(int a, int b) {
        System.out.println("Multiplication: " + a * b);
    }

    public void div(int a, int b) {
        if (b != 0) {
            System.out.println("Division: " + a / b);
        } else {
            System.out.println("Division: Cannot divide by zero");
        }
    }

    public void rem(int a, int b) {
        if (b != 0) {
            System.out.println("Remainder: " + (a % b));
        } else {
            System.out.println("Remainder: Cannot find remainder with zero");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArithmeticOperations obj = new ArithmeticOperations();

        System.out.print("Enter first number: ");
        int num1 = sc.nextInt();

        System.out.print("Enter second number: ");
        int num2 = sc.nextInt();

        obj.add(num1, num2);
        obj.sub(num1, num2);
        obj.mul(num1, num2);
        obj.div(num1, num2);
        obj.rem(num1, num2);

        sc.close();
    }
}
