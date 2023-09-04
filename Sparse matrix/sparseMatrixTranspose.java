import java.util.Arrays;

public class sparseMatrixTranspose {
    public static void main(String[] args) {
        int[][] sparseMatrix = {
                { 4, 5, 7 },
                { 1, 2, 9 },
                { 1, 4, 5 },
                { 2, 1, 2 },
                { 2, 2, 3 },
                { 3, 0, 3 },
                { 3, 1, 1 },
                { 3, 3, 4 }
        };
        System.out.println("Sparse Matrix: ");
        for (int[] row : sparseMatrix)
            System.out.println(Arrays.toString(row));

        //Created traspose matrix to store Transpose Matrix
        int[][] transpose = new int[sparseMatrix.length][3];
        
        //first row swaping 
        transpose[0][0] = sparseMatrix[0][1];
        transpose[0][1] = sparseMatrix[0][0];
        transpose[0][2] = sparseMatrix[0][2];

        //no of cols in sparse matrix
        int n = sparseMatrix[0][1];

        //no of cols in sparse matrix
        int nonZero = sparseMatrix[0][2];

        //create count matrix to store the count of non zero element in ith row
        int[] count = new int[n];

        for(int i = 1; i <=nonZero; i++){
            count[sparseMatrix[i][1]] = count[sparseMatrix[i][1]] + 1;
        }
        System.out.println("\nCount Matrix: " + Arrays.toString(count));

        //create index matrix to store the index of row to insert element in sorted order
        int[] index = new int[n];
        index[0] = 1;
        for(int i = 1; i < n; i++){
            index[i] = index[i-1] + count[i-1];
        }
        System.out.println("\nindex Matrix: " + Arrays.toString(index));

        //
        for(int i = 1; i < nonZero+1; i++){
            int pos = sparseMatrix[i][1];
            int p = index[pos];
            transpose[p][0] = sparseMatrix[i][1];
            transpose[p][1] = sparseMatrix[i][0];
            transpose[p][2] = sparseMatrix[i][2];
            index[pos] = index[pos] +1;
        }

        System.out.println("Transpose of Sparse Matrix: ");
        for (int[] row : transpose)
            System.out.println(Arrays.toString(row));

    }
}
