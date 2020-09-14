/* Intersection of Two Linked Lists
 * Example:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * */

public class LeetCode0160 {
    public static void main(String args[]){
        int[] inputA = new int[]{4,1,8,4,5};
        ListNode headA = buildListNode(inputA);
        int[] inputB = new int[]{5,6,1};
        ListNode headB = buildListNode(inputB);
        headB.next.next.next = headA.next.next;

        ListNode res = getIntersectionNode(headA, headB);
        if(res != null)
            System.out.println(res.val);
        else
            System.out.println(res);
    }

    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int countA = countList(headA);
        int countB = countList(headB);

        while(countA>countB){
            headA = headA.next;
            countA--;
        }
        while(countB>countA){
            headB = headB.next;
            countB--;
        }

        while(headA != null && headB !=null){
            if(headA == headB)
                return headA;
            headA = headA.next;
            headB = headB.next;
        }
        return null;
    }

    public static int countList(ListNode head){
        int count = 0;
        ListNode node = head;
        while(node != null){
            node = node.next;
            count ++;
        }
        return count;
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
