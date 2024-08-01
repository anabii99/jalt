import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }

        // Java's Arrays.sort method doesn't directly support
        // sorting primitive arrays (int[]) with a lambda comparator.
        // We can convert the primitive int into Integer objects
        // to get around this limitation.
        Integer[] numsObj = new Integer[nums.length];
        for (int i = 0; i < nums.length; i++) {
            numsObj[i] = nums[i];
        }

        Arrays.sort(numsObj, (a, b) -> {
            if (freq.get(a).equals(freq.get(b))) {
                return Integer.compare(b, a);
            }
            return Integer.compare(freq.get(a), freq.get(b));
        });

        // Convert numsObj back to a primitive array to match
        // return type.
        for (int i = 0; i < nums.length; i++) {
            nums[i] = numsObj[i];
        }

        return nums;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 3, 2, 4, 6, 7, 9, 2, 19};
        int[] result = solution.frequencySort(nums);
        System.out.println("Sorted array: " + Arrays.toString(result));
    }
}