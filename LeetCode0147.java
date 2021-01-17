/* Insertion Sort List
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
 * */

public class LeetCode0147 {
    public static void main(String[] args) {
        int[] input = new int[]{4, 2, 1, 3};
        ListNode head = buildListNode(input);
        ListNode sorted = insertionSortList(head);
        while (sorted != null) {
            System.out.println(sorted.val);
            sorted = sorted.next;
        }
    }

    public static ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;
        // 增加伪首部防止插入位置为首位
        ListNode dummy = new ListNode(Integer.MIN_VALUE);
        dummy.next = head;

        ListNode curr = head;
        ListNode compare = new ListNode();  // 用于比大小
        ListNode temp = new ListNode();     // 存需要移位的节点

        while (curr != null && curr.next != null) {
            if (curr.val <= curr.next.val)
                curr = curr.next;
            else {
                // 取出需要移位的节点存在temp中
                temp = curr.next;
                curr.next = curr.next.next;
                // 比较和插入
                compare = dummy;
                while (temp.val >= compare.next.val)
                    compare = compare.next;
                temp.next = compare.next;
                compare.next = temp;
            }
        }
        return dummy.next;
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
