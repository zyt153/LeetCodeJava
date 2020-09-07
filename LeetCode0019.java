/* Remove Nth Node From End of List
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * */

public class LeetCode0019 {
    public static void main(String args[]){
        int[] input = new int[]{1,2};
        ListNode head = buildListNode(input);
        int n = 2;
        ListNode output = removeNthFromEnd(head, n);

        while (output != null) {
            System.out.println(output.val);
            output = output.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        ListNode pointer1 = dummyHead;
        ListNode pointer2 = dummyHead;

        for(int i = 0; i <= n; i++)
            pointer1 = pointer1.next;
        if(pointer1 == null){
            head = head.next;
            return head;
        }

        while(pointer1 != null){
            pointer1 = pointer1.next;
            pointer2 = pointer2.next;
        }
        pointer2.next = pointer2.next.next;
        return head;
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
