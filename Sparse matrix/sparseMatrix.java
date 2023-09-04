import java.util.Arrays;

public class sparseMatrix {
    public static void main(String[] args) {
        int[][] a = {
                { 0,0,0,0,0},
                { 0,0,10,0,12},
                { 0,0,0,0,0},
                { 0,0,0,5,0},
                { 0,15,12,0,0}
        };
        int count = 0;
        for(int i = 0 ; i < a.length; i++){
            for(int j = 0 ; j < a[0].length; j++){
                if(a[i][j] != 0){
                    count++;
                }
            }
        }
        int[][] sparse = new int[count + 1][3];
        sparse[0][0] = a.length;
        sparse[0][1] = a[0].length; 
        sparse[0][2] = count;
        int k = 1;
        for(int i = 0 ; i < a.length; i++){
            for(int j = 0 ; j < a[0].length; j++){
                if(a[i][j] != 0){
                    sparse[k][0] = i;
                    sparse[k][1] = j;
                    sparse[k][2] = a[i][j];
                    k++;
                }
            }
        }
        for (int[] row : sparse)
            System.out.println(Arrays.toString(row));

    }
}