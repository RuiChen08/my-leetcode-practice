public class RotateImage {

    public static void main(String[] args) {
        RotateImage r = new RotateImage();
        r.rotate(new int[][] {{1,2,3},{4,5,6},{7,8,9}});
    }

    public void rotate(int[][] matrix) {
        int n = matrix.length;
        for (int i = 0; i < n / 2; i++){
            for (int h = i; h < n - i - 1; h++){
                int temp = matrix[i][h];
                System.out.println(i + " " + h);
                for (int count = 0; count < 4; count++) {
                    int tempi = i;
                    i = h;
                    h = n - tempi - 1;
                    temp = change(matrix, i, h, temp);
                }
                System.out.println(i + " " + h);
                System.out.println();
            }
            break;
        }
    }

    private int change(int[][] matrix, int i, int h, int value){
        int temp = matrix[i][h];
        matrix[i][h] = value;
        return temp;
    }
}
