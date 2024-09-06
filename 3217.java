import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode dummy = new ListNode(0, head);
        Set<Integer> numsSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());

        for (ListNode curr = dummy; curr.next != null;)
            if (numsSet.contains(curr.next.val))
                curr.next = curr.next.next;
            else
                curr = curr.next;

        return dummy.next;
    }
}

class LinkedListUtils {
    public static ListNode createLinkedList(int[] values) {
        if (values.length == 0)
            return null;
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
            System.out.print(current.val + " ");
            current = current.next;
        }
        System.out.println();
    }
}

class Main {
    public static void main(String[] args) {
        // Create the linked list: 1 -> 2 -> 6 -> 3 -> 4 -> 5 -> 6
        int[] listValues = { 1, 2, 6, 3, 4, 5, 6 };
        ListNode head = LinkedListUtils.createLinkedList(listValues);

        // Define the nums array which contains values to be removed
        int[] nums = { 6 };

        // Create a Solution instance and call the modifiedList method
        Solution solution = new Solution();
        ListNode modifiedHead = solution.modifiedList(nums, head);

        // Print the result
        System.out.print("Modified List: ");
        LinkedListUtils.printLinkedList(modifiedHead); // Expected output: 1 2 3 4 5
    }
}
