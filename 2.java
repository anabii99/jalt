class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class Main {
    public static void main(String[] args) {
        int[] l1Array = { 2, 4, 3 };
        int[] l2Array = { 5, 6, 4 };

        ListNode l1 = arrayToListNode(l1Array);
        ListNode l2 = arrayToListNode(l2Array);

        Solution s = new Solution();
        ListNode result = s.addTwoNumbers(l1, l2);

        printLinkedList(result); // Output: [7, 0, 8]
    }

    // Utility function to convert int[] to ListNode
    private static ListNode arrayToListNode(int[] array) {
        if (array == null || array.length == 0) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;

        for (int num : array) {
            current.next = new ListNode(num);
            current = current.next;
        }

        return dummyHead.next;
    }

    // Utility function to print a ListNode
    private static void printLinkedList(ListNode head) {
        ListNode current = head;
        StringBuilder sb = new StringBuilder("[");

        while (current != null) {
            sb.append(current.val);
            if (current.next != null) {
                sb.append(", ");
            }
            current = current.next;
        }

        sb.append("]");
        System.out.println("Output: " + sb.toString());
    }

    // Method to add two numbers represented by linked lists

}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
            if (l1 != null)
                l1 = l1.next;
            if (l2 != null)
                l2 = l2.next;
        }

        if (carry > 0) {
            current.next = new ListNode(carry);
        }

        return dummyHead.next;
    }
}