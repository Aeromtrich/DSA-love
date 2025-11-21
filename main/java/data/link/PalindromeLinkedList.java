package data.link;

// 定义链表结点
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

// leecode 234 判断是否回文链表  // 用数组的解法确实简单的多的多
public class PalindromeLinkedList {

    // 主判断函数：判断链表是否为回文
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true; // 空或单节点一定是回文

        // 1. 使用快慢指针找到中点（slow最后停在中点或中点左侧）
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 当链表长度为偶数时，slow 指向右半部分的第一个节点
        // 当链表长度为奇数时，slow 指向中间节点（需要跳过中间节点比较）

        // 2. 反转 slow 指向的后半链表
        ListNode secondHead = reverseList(slow);

        // 3. 从头和 secondHead 同步比较节点
        ListNode p1 = head;
        ListNode p2 = secondHead;
        boolean palindrome = true;
        while (p2 != null) {

            if (p1.val != p2.val) {
                palindrome = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        // 4. （可选）把后半链表反转回来，恢复原链表结构
//        reverseList(secondHead);
        return palindrome;
    }

    // 反转链表，返回新头节点
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    // 简单测试
    public static void main(String[] args) {
        PalindromeLinkedList sol = new PalindromeLinkedList();

        // 构造链表 1->2->2->1
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(2);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        System.out.println(sol.isPalindrome(n1)); // true

        // 构造链表 1->2
        ListNode a1 = new ListNode(1);
        ListNode a2 = new ListNode(2);
        a1.next = a2;
        System.out.println(sol.isPalindrome(a1)); // false

        // 单节点
        ListNode single = new ListNode(5);
        System.out.println(sol.isPalindrome(single)); // true
    }
}