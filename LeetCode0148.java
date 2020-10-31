/* Find All Anagrams in a String
 * Input: head = [-1,5,3,4,0]
 * Output: [-1,0,3,4,5]
 * Follow up: Can you sort the linked list in O(n logn) time and O(1) memory (i.e. constant space)?
 * */

public class LeetCode0148 {
    public static void main(String args[]) {
        int[] input = new int[]{-1, 5, 3, 4, 0};
        ListNode head = buildListNode(input);
        ListNode output = sortList(head);
        while (output != null) {
            System.out.print(output.val + "->");
            output = output.next;
        }
    }

    //此方法不满足空间复杂度O(1)的要求但是我真不会了
    public static ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode fast = head.next, slow = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode tmp = slow.next;
        slow.next = null;   //从中间分成两部分

        //递归将每段链表从中间分开
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        ListNode h = new ListNode(0);
        ListNode res = h;
        //将left和right整合到一起
        while (left != null && right != null) {
            if (left.val < right.val) {
                h.next = left;
                left = left.next;
            } else {
                h.next = right;
                right = right.next;
            }
            h = h.next;
        }
        h.next = left != null ? left : right;
        return res.next;
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
