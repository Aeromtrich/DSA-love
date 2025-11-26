package data.link;

import java.util.HashMap;
import java.util.Map;

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

// leecode 138 复制带随机指针的链表
class leecode138 {


    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        oldToCopy.put(null, null);
        
        // 第一遍遍历：创建所有新节点，建立原节点到新节点的映射
        Node cur = head;
        while (cur != null) {
            Node copy = new Node(cur.val);
            oldToCopy.put(cur, copy);
            cur = cur.next;
        }
        
        // 第二遍遍历：设置新节点的next和random指针
        cur = head;
        while (cur != null) {
            Node copy = oldToCopy.get(cur);
            copy.next = oldToCopy.get(cur.next);
            copy.random = oldToCopy.get(cur.random);
            cur = cur.next;
        }
        
        return oldToCopy.get(head);
    }
}