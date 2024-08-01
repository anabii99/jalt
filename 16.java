import java.util.Arrays;

class Pair {
    int[] nums;
    int target;

    Pair(int[] nums, int target) {
        this.nums = nums;
        this.target = target;
    }
}

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans = nums[0] + nums[1] + nums[2];

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                int summ = nums[i] + nums[l] + nums[r];
                if (summ == target) {
                    return summ;
                }
                if (Math.abs(summ - target) < Math.abs(ans - target)) {
                    ans = summ;
                }
                if (summ < target) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        return ans;
    }

}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Define test cases using Pair objects
        Pair[] testCases = {
            new Pair(new int[]{-1, 2, 1, -4}, 1),
            new Pair(new int[]{0, 2, 1, -3}, 1),
            new Pair(new int[]{-1, 2, 1, -4}, 1),
            new Pair(new int[]{1, 1, 1, 0}, -100),
            new Pair(new int[]{1, 1, 1, 0}, 100),
            new Pair(new int[]{-1, 0, 1, 1, 55}, 3)
        };

        // Run the test cases
        for (Pair testCase : testCases) {
            int result = solution.threeSumClosest(testCase.nums, testCase.target);
            System.out.println("The sum closest to " + testCase.target + " for array " + Arrays.toString(testCase.nums) + " is: " + result);
        }
    }
}