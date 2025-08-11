//to multiply 2 matrices
public class MatrixMultiplication {
    public static int[][] main(String[] args) {
        int[][] A = {
            {1, 2, 3},
            {4, 5, 6}
        };

        int[][] B = {
            {7, 8},
            {9, 10},
            {11, 12}
        };
      
        int rowsA = A.length;
        int colsA = A[0].length;
        int colsB = B[0].length;
        int rowsB = B.length;
        // Check if multiplication is possible or not
        if (colsA != rowsB) {
            System.out.println("Matrix multiplication not possible");
            return;
        }
        int[][] result = new int[rowsA][colsB];

        // Multiply matrices
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
      return result;
    }
}


// If instead of matrices there are arraylists-

public static ArrayList<ArrayList<Integer>> matrixMultiply(ArrayList<ArrayList<Integer>> A)         //square matrix both same to multiply
{
        int n = A.size();
        ArrayList<ArrayList<Integer>> B = new ArrayList<>();                  //resulting matrix

        for (int i = 0; i < n; i++) 
        {
            ArrayList<Integer> row = new ArrayList<>();                       // i loop add rows to result matrix
            for (int j = 0; j < n; j++)                                       // j loop fill row by column-wise
            {
                int sum = 0;
                for (int k = 0; k < n; k++) 
                {
                    sum += A.get(i).get(k) * A.get(k).get(j);
                }
                row.add(sum); 
            }
            B.add(row);                                                      // row complete at end of i loop
        }
        return B;
    }
}

