/* Add Two Numbers
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 * */

public class LeetCode0002 {
    public static void main(String args[]) {
        int[] input1 = new int[]{1};
        ListNode l1 = buildListNode(input1);

        int[] input2 = new int[]{9,9};
        ListNode l2 = buildListNode(input2);

        ListNode output = addTwoNumbers(l1, l2);
        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            curr.next = new ListNode((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
            curr = curr.next;

            if (p != null)
                p = p.next;
            if (q != null)
                q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }

    private static ListNode buildListNode(int[] input) {
        ListNode first = null, last = null, newNode;
        if (input.length > 0) {
            for (int i = 0; i < input.length; i++) {
                newNode = new ListNode(input[i]);
                newNode.next = null;
                if (first == null) {
                    first = newNode;
                    last = newNode;
                } else {
                    last.next = newNode;
                    last = newNode;
                }
            }
        }
        return first;
    }
}
