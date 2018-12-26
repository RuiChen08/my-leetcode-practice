public class Search2DMatrix {

    public static void main(String[] args) {
        Search2DMatrix s = new Search2DMatrix();
        System.out.println(s.searchMatrix(new int[][] {{1,   3,  5,  7},{10, 11, 16, 20},{23, 30, 34, 50}}, 13));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        int low = 0, high = matrix.length - 1;

        while (high - low > 1){
            int mid = low + (high - low) / 2;
            if (matrix[mid][0] > target) high = mid;
            else if (matrix[mid][0] == target) return true;
            else low = mid;
        }

        if (matrix[0].length == 0) return false;
        int row = matrix[high][0] <= target ? high : low;
        low = 0;high = matrix[0].length - 1;
        while (high - low > 1){
            int mid = low + (high - low) / 2;
            if (matrix[row][mid] > target) high = mid;
            else if (matrix[row][mid] == target) return true;
            else low = mid;
        }
        return matrix[row][high] == target || matrix[row][low] == target;
    }

}
