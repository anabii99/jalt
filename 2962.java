class Solution {
    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int max = 0, count = 0, n = nums.length;
        for (int num : nums)
            max = Math.max(max, num);
        int l = 0;
        for (int r = 0; r < n; r++) {
            if (nums[r] == max)
                count++;
            while (count >= k) {
                res += n - r;
                if (nums[l] == max)
                    count--;
                l++;
            }
        }
        return res;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        // int[] nums = new int[] { 1, 3, 2, 3, 3 };
        int[] nums = { 1, 3, 2, 3, 3 };
        int k = 2;
        System.out.println(solution.countSubarrays(nums, k));
    }
}
