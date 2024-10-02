import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] { map.get(complement), i };
            }
            map.put(nums[i], i);
        }
        throw new AssertionError("Error");
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[] { 2, 1, 11, 1 };
        int target = 12;
        System.out.println(Arrays.toString(solution.twoSum(nums, target)));

    }
}
