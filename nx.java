import java.util.Scanner;

public class nx {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[7];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = scanner.nextInt();
        }
        scanner.close();

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 11) {
                arr[i] = 21;
            } else if (arr[i] == 7) {
                arr[i] = 27;
            }
        }
        
        
        int index0 = arr[0];
        int indexLast = arr[arr.length - 1];
	int sum = arr[0]+arr[6];
        for (int num : arr) {
            sum += num;
        }
        int sum2 = index0 + indexLast;
        
        
        System.out.println(java.util.Arrays.toString(arr));
        System.out.println("Sum: " + sum);
        System.out.println("Sum of First and Last: " + sum2);
        System.out.println("Index 0: " + index0);
        System.out.println("Index Last: " + indexLast);
    }
}