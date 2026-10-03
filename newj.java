import java.util.Scanner;

class MarksArray {
    public static void main(String[] args) {
        int marks[][] = new int[3][4];
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter 12 marks (3 rows, 4 columns):");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print("marks[" + i + "][" + j + "]: ");
                marks[i][j] = sc.nextInt();
            }
        }

        System.out.println("\nThe marks array is:");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(marks[i][j] + "\t");
            }
            System.out.println();
        }
        sc.close();
    }
}
