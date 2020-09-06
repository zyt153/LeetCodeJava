/* Merge Two Sorted Lists
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * */

public class LeetCode0021 {
    public static void main(String args[]) {
        int[] input1 = new int[]{9, 9, 9, 9};
        ListNode l1 = buildListNode(input1);

        int[] input2 = new int[]{1, 3, 4};
        ListNode l2 = buildListNode(input2);

        ListNode output = mergeTwoLists(l1, l2);
        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode dummyHead = new ListNode(0);
        ListNode mergedList = dummyHead;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                mergedList.next = l1;
                l1 = l1.next;
            } else {
                mergedList.next = l2;
                l2 = l2.next;
            }
            mergedList = mergedList.next;
        }

        if (l2 != null)
            mergedList.next = l2;

        if (l1 != null)
            mergedList.next = l1;

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
