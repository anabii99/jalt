class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIdx = new int[128];

        int maxLen = 0;
        for (int start = 0, end = 0; end < s.length(); end++) {
            char curr = s.charAt(end);
            start = Math.max(start, lastIdx[curr]);
            maxLen = Math.max(maxLen, end - start + 1);
            lastIdx[curr] = end + 1;
        }

        return maxLen;
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage 1:
        String s1 = "abcabcbb";
        int length1 = solution.lengthOfLongestSubstring(s1);
        System.out.println("Length of longest substring in \"" + s1 + "\": " + length1); // Output: 3

        // Example usage 2:
        String s2 = "bbbbb";
        int length2 = solution.lengthOfLongestSubstring(s2);
        System.out.println("Length of longest substring in \"" + s2 + "\": " + length2); // Output: 1

        // Example usage 3:
        String s3 = "pwwkew";
        int length3 = solution.lengthOfLongestSubstring(s3);
        System.out.println("Length of longest substring in \"" + s3 + "\": " + length3); // Output: 3
    }
}