package com.yys.LinkedList;

public class _141_HasCycle {

    //快慢指针
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode slow = head;
        ListNode quick = head.next;
        while (slow!=quick) {
            if (quick==null ||quick.next==null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }
}
