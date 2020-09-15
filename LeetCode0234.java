/* Palindrome Linked List
 * Example:
 * Input: 1->2->2->1
 * Output: true
 * */

public class LeetCode0234 {
    public static void main(String args[]) {
        int[] input = new int[]{1, 2, 3, 4, 2, 1};
        ListNode head = buildListNode(input);

        System.out.println(isPalindrome(head));
    }

    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = slow;     //找到中点

        ListNode reversed = slow;   //从此处开始反转
        ListNode toDo = slow.next;  //要处理的ListNode
        middle.next = null;         //中点指向null

        while (toDo != null) {        //从中点开始反向，直到toDo为null（此时reversed为反向后的headListNode）
            ListNode temp = toDo.next;
            toDo.next = reversed;
            reversed = toDo;
            toDo = temp;
        }

        while (head != null && reversed != null) {  //从头比较两个链表
            if (head.val != reversed.val) {
                return false;
            }
            head = head.next;
            reversed = reversed.next;
        }

        return true;
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
