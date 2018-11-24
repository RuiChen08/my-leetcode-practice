public class RemoveElement {

    public static void main(String[] args) {
        RemoveElement e = new RemoveElement();
        System.out.println(e.removeElement(new int[] {3}, 3));
    }

    public int removeElement(int[] nums, int val) {
        int pivot = nums.length - 1;
        for (int i = 0; i <= pivot; i++){
            if (nums[i] == val) nums[i--] = nums[pivot--];
        }
        return pivot < 0 ? 0 : pivot + 1;
    }
}
