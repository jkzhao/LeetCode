import java.util.HashMap;
import java.util.Map;

/**
 * Created by jkzhao on 3/26/18.
 */
public class TwoSum {
    /**
     * input: nums = [2, 7, 11, 15], target = 9
     * output [0, 1]
     *
     * time complexity: O(n)
     * space complexity: O(n)
     *
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int other = target - nums[i];
            if (map.containsKey(other) && map.get(other) != i) {
                return new int[] { i, map.get(other) };
            }
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
