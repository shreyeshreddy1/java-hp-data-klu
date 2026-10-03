public class quecj {
    public static void main(String[] args) {
        int [][] marks = {
            {80,75,90},
            {70,85,88},
            {92,80,95}
        };
        for(int i=0; i<marks.length; i++){
            System.out.print("Student " + (i+1) + ": ");

            
            for(int j=0; j<marks[i].length; j++){
                System.out.print(marks[i][j] + " ");
            }
            System.out.println();
        }
    }
    
}
