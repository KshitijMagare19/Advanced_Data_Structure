import java.util.Arrays;

public class sparseMatrixAddition {
    public static void main(String[] args) {
        int[][] a = {
                { 5, 5, 5 },
                { 1, 2, 10 },
                { 1, 4, 12 },
                { 3, 3, 5 },
                { 4, 1, 15 },
                { 4, 2, 12 }
        };
        int[][] b = {
                { 5, 5, 5  },
                { 1, 3, 8 },
                { 2, 4, 23 },
                { 3, 3, 9 },
                { 4, 1, 20 },
                { 4, 2, 25 }
        };
        int[][] c = {
                { 5, 5, 5  },
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 },
                { 0, 0, 0 }
        };
        int i = 1, j = 1;
        for(int k = 1; k < c.length; k++){

            if(a[i][0] == b[j][0] && a[i][1] == b[j][1] ){
                c[k][0] = a[i][0];
                c[k][1] = a[i][1];
                c[k][2] = a[i][2] + b[j][2];
                i++;
                j++;
            }
            else if(a[i][0] == b[j][0] && a[i][1] != b[j][1] ){
                if(a[i][1] > b[j][1]){
                    c[k][0] = b[j][0];
                    c[k][1] = b[j][1];
                    c[k][2] = b[j][2];
                    j++;
                }
                else{
                    c[k][0] = a[i][0];
                    c[k][1] = a[i][1];
                    c[k][2] = a[i][2];
                    i++;
                }
            }
            else{
                if(a[i][0] > b[j][0]){
                    c[k][0] = b[j][0];
                    c[k][1] = b[j][1];
                    c[k][2] = b[j][2];
                    j++;
                }
                else{
                    c[k][0] = a[i][0];
                    c[k][1] = a[i][1];
                    c[k][2] = a[i][2];
                    i++;
                }
            }
        }

        System.out.println("Sparse Matrix: \n");
        for (int[] row : c)
            System.out.println(Arrays.toString(row));

    }
}