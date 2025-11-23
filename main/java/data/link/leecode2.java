package data.link;

// leecode 2 两数相加
class leecode2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 创建虚拟头节点 dummy
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        int carry = 0;  // 进位值

        // 只要 l1 或 l2 不为空 或 还有进位，就继续算
        while (l1 != null || l2 != null || carry != 0) {

            // 如果 l1 不为空，就取数字，否则用 0
            int v1 = (l1 != null) ? l1.val : 0;
            int v2 = (l2 != null) ? l2.val : 0;
            // 当前位求和
            int sum = v1 + v2 + carry;

            // 更新进位  // 5 + 7 = 12 /10 -> 1
            carry = sum / 10;

            // 当前节点值（取个位）
            // 12 % 10 -> 2
            int value = sum % 10;
            // 创建新节点接到 cur.next
            cur.next = new ListNode(value);

            // cur 往后移动
            cur = cur.next;

            // l1、l2 向后走
            l1 = (l1 != null) ? l1.next : null;
            l2 = (l2 != null) ? l2.next : null;
        }

        // 返回真正的链表头（跳过 dummy）
        return dummy.next;
    }
}