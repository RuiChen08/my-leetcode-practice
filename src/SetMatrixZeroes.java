public class SetMatrixZeroes {

    public static void main(String[] args) {
        SetMatrixZeroes s = new SetMatrixZeroes();
        s.setZeroes(new int[][] {{1,1,1},{1,0,1},{1,1,1}});
    }

    public void setZeroes(int[][] matrix) {
        int record = -1;

        for (int m = 0; m < matrix.length; m++)
            if (containZero(matrix, m))
                record = setRowtoZero(matrix, m, record);

        if (record != -1)
            for (int n = 0; n < matrix[0].length; n++)
                if (matrix[record][n] == 1)
                    setColtoZero(matrix, n);
    }

    public boolean containZero(int[][] matrix, int row){
        for (int n = 0; n < matrix[0].length; n++) {
            if (matrix[row][n] == 0) return true;
        }
        return false;
    }

    public int setRowtoZero(int[][] matrix, int row, int record){
        if (record == -1) record = row;
        for (int n = 0; n < matrix[0].length; n++) {
            if (matrix[row][n] == 0) matrix[record][n] = 1;
            else matrix[row][n] = 0;
        }
        return record;
    }

    public void setColtoZero(int[][] matrix, int col){
        for (int m = 0; m < matrix.length; m++) {
            matrix[m][col] = 0;
        }
    }
}
