package data.link;

// LeetCode 已提供 ListNode，这里重写方便本地跑
// leetcode 21 合并两个有序链表
public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // 建一个虚拟头节点（dummy）
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy; // tail 指向结果链表的尾部


        // 两个链表都不空时，逐个比较  // 链接 l1 到结果链表  // l1 往前走  // 结果链表尾指针前进
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                tail.next = l1;
                l1 = l1.next;
            } else {
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        // 有一个链表先走完了，把另一个全部接上
        if (l1 != null) {
            tail.next = l1;
        } else {
            tail.next = l2;
        }

        // dummy.next 才是真正的头节点
        return dummy.next;
    }
}