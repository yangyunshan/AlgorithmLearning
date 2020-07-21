package com.yys.LinkedList;

public class _206_ReverseLinkList {

    //在遍历列表时，将当前节点的 next 指针改为指向前一个元素。由于节点没有引用其上一个节点，因此必须事先存储其前一个元素。
    // 在更改引用之前，还需要另一个指针来存储下一个节点。不要忘记在最后返回新的头引用！


    //迭代方式
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr!=null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    //递归方式, p是反转后链表的表头
    public ListNode reverse(ListNode head) {
        if (head==null ||head.next==null) {
            return head;
        }
        ListNode p = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return p;
    }

    public void printList(ListNode head) {
        while (head!=null) {
            System.out.print(head.val+" ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        _206_ReverseLinkList test = new _206_ReverseLinkList();

        test.printList(node1);

        ListNode head = test.reverseList(node1);
        System.out.println();
        System.out.print("Reverse:");
        test.printList(head);
    }
}
