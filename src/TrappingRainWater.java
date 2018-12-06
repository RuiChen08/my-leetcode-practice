public class TrappingRainWater {
    //
    public int trap(int[] height) {
        if (height.length == 0) return 0;
        int left = 0, right = height.length -  1, leftMax = height[left], rightMax = height[right], ans = 0;

        while (left != right){
            if (height[left] < height[right]){
                if (height[left] > leftMax) leftMax = height[left];
                else ans += leftMax - height[left];
                left++;
            } else {
                if (height[right] > rightMax) rightMax = height[right];
                else ans += rightMax - height[right];
                right--;
            }
        }
        return ans;
    }
}
