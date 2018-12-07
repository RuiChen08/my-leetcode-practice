import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Permutations {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new LinkedList<>();
        generatePermutation(list, new LinkedList<>(), nums);
        return list;
    }

    private void generatePermutation(List<List<Integer>> list, List<Integer> tempList, int [] nums){
        if(tempList.size() == nums.length){
            list.add(new LinkedList<>(tempList));
        } else {
            for (int num : nums) {
                if (tempList.contains(num)) continue;
                tempList.add(num);
                generatePermutation(list, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        Permutations p = new Permutations();
        System.out.println(p.permuteUnique(new int[] {3,3,0,3}));
    }

    //Leetcode problem 47
    public List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> maps = new HashMap<>();
        for (int in : nums){
            if (!maps.containsKey(in)) maps.put(in, 1);
            else maps.put(in, maps.get(in) + 1);
        }
        List<List<Integer>> list = new LinkedList<>();
        generatePermutationHelper(list, new LinkedList<>(), nums, maps);
        return list;
    }

    private void generatePermutationHelper(List<List<Integer>> list, List<Integer> tempList, int [] nums, Map<Integer, Integer> maps){
        List<Integer> lastone = new LinkedList<>();
        if(tempList.size() == nums.length){
            list.add(new LinkedList<>(tempList));
        } else {
            for (int num : nums) {
                if (maps.get(num) == 0 || lastone.contains(num)) continue;
                lastone.add(num);
                tempList.add(num);
                maps.put(num, maps.get(num) - 1);
                generatePermutationHelper(list, tempList, nums, maps);
                tempList.remove(tempList.size() - 1);
                maps.put(num, maps.get(num) + 1);
            }
        }
    }
}

