public class MaxAreaContainer {

    public static void main(String[] args) {
        MaxAreaContainer maxAreaContainer = new MaxAreaContainer();
        System.out.println(maxAreaContainer.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
    }

    public int maxArea(int[] height) {
        int max = 0, i = 0, j = height.length - 1;
        while (i != j){
            max = Math.max(Math.min(height[i], height[j]) * (j - i), max);
            if (height[i] < height[j]){
                i++;
            } else {
                j--;
            }
        }
        return max;
    }

//    public int maxArea(int[] height) {
//        int max = 0;
//        for (int i = 0; i < height.length; i++){
//            for (int j = i; j < height.length; j++){
//                max = Math.max( Math.min(height[j], height[i]) * (j - i), max);
//            }
//        }
//        return max;
//    }

}
