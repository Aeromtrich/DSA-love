package data.link;

// leecode 24 两两交换链表中的节点
class leecode24 {
    public ListNode swapPairs(ListNode head) {
        // 创建虚拟头节点，简化边界条件处理
        ListNode dummy = new ListNode(0, head);
        // prev指向当前要交换的一对节点的前一个节点
        // curr指向当前要交换的第一个节点
        ListNode prev = dummy, curr = head;
        
        // 当存在至少两个节点可以交换时继续循环
        while (curr != null && curr.next != null) {
            // 保存指针
            ListNode nxtPair = curr.next.next; // 下一对节点的起始位置
            ListNode second = curr.next;       // 当前要交换的第二个节点
            
            // 交换当前这一对节点
            second.next = curr;    // 第二个节点指向第一个节点
            curr.next = nxtPair;   // 第一个节点指向下一对节点
            prev.next = second;    // 前驱节点指向新的第一个节点（原来的第二个节点）
            
            // 更新指针，准备处理下一对节点
            prev = curr;           // prev移动到当前这对节点交换后的第二个节点
            curr = nxtPair;        // curr移动到下一对节点的第一个节点
        }
        
        return dummy.next; // 返回交换后的链表头节点
    }
}