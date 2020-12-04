/* Copy List with Random Pointer
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * */

import java.util.HashMap;
import java.util.Map;

public class LeetCode0138 {
    public static void main(String args[]) {
        Node node0 = new Node(7);
        Node node1 = new Node(13);
        Node node2 = new Node(11);
        Node node3 = new Node(10);
        Node node4 = new Node(1);

        node0.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        node1.random = node0;
        node2.random = node4;
        node3.random = node2;
        node4.random = node0;

        Node copy = copyRandomList(node0);
        while (copy != null) {
            System.out.print(copy.val + ",");
            if (copy.random != null)
                System.out.println(copy.random.val);
            else
                System.out.println("null");
            copy = copy.next;
        }
    }

    public static Node copyRandomList(Node head) {
        if (head == null)
            return null;

        // 映射关系为 原节点->复制节点
        Map<Node, Node> map = new HashMap<>();
        // 将原节点进行复制（仅值，不包括指针），并存储到哈希表中
        Node p = head;
        while (p != null){
            Node copy = new Node(p.val);
            map.put(p, copy);
            p = p.next;
        }
        // 修改复制节点的指针
        p = head;
        while (p != null){
            Node copy = map.get(p);
            if (p.next != null)
                copy.next = map.get(p.next);
            if (p.random != null)
                copy.random = map.get(p.random);
            p = p.next;
        }

        return map.get(head);
    }
}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}