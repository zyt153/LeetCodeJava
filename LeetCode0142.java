/* Linked List Cycle II
 * Input: head = [3,2,0,-4], pos = 1
 * 3->2->0->-4
 *    |      |
 *    --------
 * Output: tail connects to node index 1
 * Explanation: There is a cycle in the linked list, where tail connects to the second node.
 * */

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LeetCode0142 {
    public static void main(String args[]) {
        int[] input = new int[]{3, 2, 0, -4};
        ListNode l1 = buildLoopListNode(input, 1);
        System.out.println(detectCycle(l1).val);
    }

    public static ListNode detectCycle(ListNode head) {
        /* Use HashSet: Time complex: O(N), Space complex: O(N)
        if (head == null)
            return null;

        ListNode pos = head;
        Set<ListNode> visited = new HashSet<ListNode>();
        while (pos != null) {
            if (visited.contains(pos))
                return pos;
            else
                visited.add(pos);
            pos = pos.next;
        }
        return null;*/

        // Use two pointers: Time complex: O(N), Space complex: O(1)
        // https://leetcode-cn.com/problems/linked-list-cycle-ii/solution/142-huan-xing-lian-biao-ii-jian-hua-gong-shi-jia-2/
        if (head == null)
            return null;
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null) {
            slow = slow.next;
            if (fast.next != null)
                fast = fast.next.next;
            else
                return null;

            if (fast == slow) {
                while (head != slow) {
                    head = head.next;
                    slow = slow.next;
                }
                return head;
            }
        }
        return null;
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
