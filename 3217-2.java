import java.util.HashSet;
import java.util.Set;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Set<Integer> numsSet = new HashSet<>();
        
        for (int num : nums) {
            numsSet.add(num);
        }
        
        ListNode curr = dummy;
        
        while (curr.next != null) {
            if (numsSet.contains(curr.next.val)) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        
        return dummy.next;
    }
}

class LinkedListUtils {
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode current = head;
        for (int i = 1; i < values.length; i++) {
            current.next = new ListNode(values[i]);
            current = current.next;
        }
        return head;
    }

    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("None");
    }
}

class Main {
    public static void main(String[] args) {
        // Example input
        int[] nums = {1, 2, 3};
        int[] headArray = {1, 2, 3, 4, 5};

        // Convert array to linked list
        ListNode head = LinkedListUtils.createLinkedList(headArray);

        // Modify the list
        Solution solution = new Solution();
        ListNode modifiedList = solution.modifiedList(nums, head);

        // Print the modified list
        System.out.print("Modified List: ");
        LinkedListUtils.printLinkedList(modifiedList);  // Expected output: 4 -> 5 -> None
    }
}