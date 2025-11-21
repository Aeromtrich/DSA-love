package data.link;


// leecode 141 环形链表
public class LinkedListCycle {

    // 方法1：Floyd 快慢指针（推荐，O(1) 额外空间）
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        // 快指针每次走两步，慢指针每次走一步
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false; // 快指针到链表末尾，说明无环
    }


    // 简单测试
    public static void main(String[] args) {
        LinkedListCycle sol = new LinkedListCycle();

        // 测试1：无环 1->2->3->null
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        System.out.println(sol.hasCycle(a)); // false

        // 测试2：有环 1->2->3->2 ...
        ListNode b1 = new ListNode(1);
        ListNode b2 = new ListNode(2);
        ListNode b3 = new ListNode(3);
        b1.next = b2;
        b2.next = b3;
        b3.next = b2; // 环从 b2 开始
        System.out.println(sol.hasCycle(b1)); // true

        // 测试3：单节点自环
        ListNode c = new ListNode(5);
        c.next = c;
        System.out.println(sol.hasCycle(c)); // true
    }
}