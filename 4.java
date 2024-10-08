class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        final int n1 = nums1.length;
        final int n2 = nums2.length;
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int l = 0;
        int r = n1;

        while (l <= r) {
            final int partition1 = (l + r) / 2;
            final int partition2 = (n1 + n2 + 1) / 2 - partition1;
            final int maxLeft1 = partition1 == 0 ? Integer.MIN_VALUE : nums1[partition1 - 1];
            final int maxLeft2 = partition2 == 0 ? Integer.MIN_VALUE : nums2[partition2 - 1];
            final int minRight1 = partition1 == n1 ? Integer.MAX_VALUE : nums1[partition1];
            final int minRight2 = partition2 == n2 ? Integer.MAX_VALUE : nums2[partition2];
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1)
                return (n1 + n2) % 2 == 0
                        ? (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) * 0.5
                        : Math.max(maxLeft1, maxLeft2);
            else if (maxLeft1 > minRight2)
                r = partition1 - 1;
            else
                l = partition1 + 1;
        }

        throw new IllegalArgumentException();
    }
}

class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage 1:
        int[] nums1 = { 1, 2 };
        int[] nums2 = { 3, 4 };
        double median1 = solution.findMedianSortedArrays(nums1, nums2);
        System.out.println("Median of merged arrays: " + median1); // Output: 2.5

        // Example usage 2:
        int[] nums3 = { 1, 3 };
        int[] nums4 = { 2 };
        double median2 = solution.findMedianSortedArrays(nums3, nums4);
        System.out.println("Median of merged arrays: " + median2); // Output: 2.0

        // Example usage 3:
        int[] nums5 = { 1, 2, 3, 4 };
        int[] nums6 = { 5, 6, 7, 8 };
        double median3 = solution.findMedianSortedArrays(nums5, nums6);
        System.out.println("Median of merged arrays: " + median3); // Output: 4.5
    }
}