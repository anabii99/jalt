import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null || carry > 0) {
            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }
            curr.next = new ListNode(carry % 10);
            carry = carry / 10;
            curr = curr.next;
        }

        return dummyHead.next;
    }
}

class Main {
    public static void main(String[] args) {
        ListNode l1 = createLinkedListFromArray(new int[] { 2, 4, 3 });
        ListNode l2 = createLinkedListFromArray(new int[] { 5, 6, 4 });

        Solution solution = new Solution();
        ListNode result = solution.addTwoNumbers(l1, l2);

        System.out.println("Input:");
        printLinkedList(l1);
        printLinkedList(l2);

        System.out.println("Output:");
        printLinkedList(result);
    }

    // Function to create a linked list from an array
    public static ListNode createLinkedListFromArray(int[] arr) {
        if (arr.length == 0)
            return null;
        ListNode head = new ListNode(arr[0]);
        ListNode current = head;
        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }
        return head;
    }

    // Function to print a linked list
    public static void printLinkedList(ListNode head) {
        ListNode current = head;
        List<Integer> values = new ArrayList<>();

        while (current != null) {
            values.add(current.val);
            current = current.next;
        }

        System.out.println(String.join(" -> ", values.stream().map(Object::toString).toArray(String[]::new)));
    }
}
