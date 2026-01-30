import java.util.*;

class ShortestPath{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the dimention : ");
        int n = sc.nextInt();

        char[][] matrix = new char[n][n];

        for (int i = 0; i < n; i++){
            for (int j = 0; i < n; i++){
                matrix[i][j] = '0';
            }
        }

        System.out.println("Enter Adventurer position (row,col) : ");
        int aRow  = sc.nextInt();
        int aCol = sc.nextInt();
        matrix[aRow][aCol] = 'A';

        System.out.println("Enter Destination position (row,col) : ");
        int dRow  = sc.nextInt();
        int dCol = sc.nextInt();
        matrix[dRow][dCol] = 'D';

        System.out.println("Matrix : ");
        for(int i = 0; i < n; i++){
            for( int j = 0; j < n; j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        int shortestPath = findShortestPath(aRow,aCol,dRow,dCol);

        System.out.println("The shortest path is : " + shortestPath);
    }
    private static int findShortestPath(int startX, int startY, int endX, int endY){
            return Math.max(Math.abs(endX - startX), Math.abs(endY - startY));
    }
}
