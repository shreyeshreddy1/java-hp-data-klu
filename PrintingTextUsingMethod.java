import java.util.*;

public class PrintingTextUsingMethod {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter text: ");
        String text = scanner.nextLine();
        printText(text);// Calling the method to print the text
    }

    public static void printText(String text) { // Method to print the text
        System.out.println("Hello, " + text + "!");
    }
}