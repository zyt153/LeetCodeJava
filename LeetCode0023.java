/* Merge k Sorted Lists
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * */

public class LeetCode0023 {
    public static void main(String args[]) {
        int[] list1 = new int[]{1, 4, 5};
        ListNode l1 = buildListNode(list1);

        int[] list2 = new int[]{1, 3, 4};
        ListNode l2 = buildListNode(list2);

        int[] list3 = new int[]{2, 6};
        ListNode l3 = buildListNode(list3);

        ListNode[] lists = {l1, l2, l3};
        ListNode output = mergeKLists(lists);
        while (output != null) {
            System.out.print(output.val + ",");
            output = output.next;
        }
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        /*ListNode res = null;
        for (int i = 0; i < lists.length; i++) {
            res = mergeTwoLists(res, lists[i]);
        }
        return res;*/
        return merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int l, int r) {
        if (l == r)
            return lists[l];
        if (l > r)
            return null;
        int mid = (l + r) / 2;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }

    public static ListNode mergeTwoLists(ListNode a, ListNode b) {
        if (a == null || b == null)
            return a != null ? a : b;
        ListNode head = new ListNode(0);
        ListNode tail = head;
        ListNode a_tobemerged = a, b_tobemerged = b;

        while (a_tobemerged != null && b_tobemerged != null) {
            if (a_tobemerged.val <= b_tobemerged.val) {
                tail.next = a_tobemerged;
                a_tobemerged = a_tobemerged.next;
            } else {
                tail.next = b_tobemerged;
                b_tobemerged = b_tobemerged.next;
            }
            tail = tail.next;
        }
        tail.next = a_tobemerged != null ? a_tobemerged : b_tobemerged;
        return head.next;
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
