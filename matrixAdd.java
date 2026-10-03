public class matrixAdd {
    public static void main(String[] args) {
        
        int[][] matrixA = { // here the matrix is 2x3
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] matrixB = {  // here the matrix is 2x3
            {7, 8, 9},
            {10, 11, 12}
        };

        int rows = matrixA.length;
        int cols = matrixA[0].length;

        
        int[][] result = new int[rows][cols];

        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                result[i][j] = matrixA[i][j] + matrixB[i][j];
            }
        }

        System.out.println("Result of Matrix Addition:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }
}