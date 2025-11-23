package data.link;

class leecode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 创建虚拟头节点，简化边界情况处理（如删除头节点）
        ListNode dummy = new ListNode(0, head);
        ListNode left = dummy;  // 慢指针，最终指向要删除节点的前一个节点
        ListNode right = head;  // 快指针，先移动n步
        
        // 快指针先移动n步
       while (n > 0 && right != null) {
           right = right.next;
           n --;
       }

        // 同时移动快慢指针，直到快指针到达链表末尾
        while (right != null) {
            left = left.next;
            right = right.next;
        }
        
        // 删除第n个节点（left.next就是要删除的节点）
        left.next = left.next.next;

        // 返回虚拟头节点的下一个节点（即真正的头节点）
        return dummy.next;
    }
}