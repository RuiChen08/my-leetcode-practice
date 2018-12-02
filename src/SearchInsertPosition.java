import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SearchInsertPosition<E> {

    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        
        int lo = 0, hi = nums.length - 1;
        while (hi - lo > 2){
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target) return mid;
            else if (nums[mid] < target) lo = mid;
            else if (nums[mid] > target) hi = mid;
        }

        return nums[lo] <= target ? lo : nums[hi] <= target ? hi : hi + 1;
    }
}
