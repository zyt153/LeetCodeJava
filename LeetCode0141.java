/* Linked List Cycle
 * Input: head = [3,2,0,-4], pos = 1
 * 3->2->0->-4
 *    |      |
 *    --------
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * */

import java.util.HashSet;
import java.util.Set;

public class LeetCode0141 {
    public static void main(String args[]){
        int[] input = new int[]{3, 2, 0, -4};
        ListNode l1 = buildLoopListNode(input, 1);
        System.out.println(hasCycle(l1));
    }

    public static boolean hasCycle(ListNode head) {
        // Use hash map
        /*if (head == null)
            return false;
        Set<ListNode> visited = new HashSet<>();
        while (head != null){
            if (visited.contains(head))
                return true;
            else
                visited.add(head);
            head = head.next;
        }
        return false;*/

        // Use two pointers
        if (head == null)
            return false;
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast){
            if (fast == null || fast.next == null)
                return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    private static ListNode buildLoopListNode(int[] input, int pos) {
        ListNode first = null, last = null, newNode, loop = null;
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

            for (int i = 0; i < pos; i++)
                loop = first.next;

            last.next = loop;
        }
        return first;
    }
}
