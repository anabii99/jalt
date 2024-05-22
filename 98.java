class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }

        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }

        return isValidBST(node.left, min, node.val) && isValidBST(node.right, node.val, max);
    }

}

class Main {
    public static TreeNode constructBST(int[] nums) {
        return constructBSTHelper(nums, 0, nums.length - 1);
    }

    private static TreeNode constructBSTHelper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(nums[mid]);

        root.left = constructBSTHelper(nums, start, mid - 1);
        root.right = constructBSTHelper(nums, mid + 1, end);

        return root;
    }

    public static void main(String[] args) {
        int[] nums = { 1, 2, 3, 4, 5, 6, 7 };
        Solution solution = new Solution();
        TreeNode root = constructBST(nums);

        // Check if the constructed tree is a valid BST
        boolean isValid = solution.isValidBST(root);
        System.out.println("Is the tree a valid BST? " + isValid); // Output: Is the tree a valid BST? true

    }
}