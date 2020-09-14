/* Reverse Linked List
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
 * */

public class LeetCode206 {
    public static void main(String args[]){
        int[] input = new int[]{1,2,3,4,5};
        ListNode head = buildListNode(input);

        ListNode res = reverseList(head);
        while(res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }

    public static ListNode reverseList(ListNode head) {
        ListNode previous = null;
        ListNode current = head;

        while(current != null){
            ListNode temp = current.next;
            current.next = previous;
            previous = current;
            current = temp;
        }
        return previous;
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
