import java.util.*;

public class Subsets {

    /**
     * https://leetcode.com/problems/subsets/
     */
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>(Collections.singleton(new LinkedList<>()));
        for (int in : nums){
            int size = ans.size();
            Iterator<List<Integer>> ite = ans.iterator();
            for (int i = 0; i < size; i++){
                List<Integer> temp = new LinkedList<>(ans.get(i));
                temp.add(in);
                ans.add(temp);
            }
        }
        return ans;
    }

}
