package com.yys.LinkedList;

public class LinkedList {
    private ListNode head;
    private int size;

    public LinkedList() {
        head = null;
        size = 0;
    }

    public ListNode getHead() {
        return this.head;
    }

    /**
     * 在链表末尾添加节点
     * @param node
     */
    public void addNode(ListNode node) {
        if (head==null) {
            head = node;
        } else {
            ListNode nowNode = head;
            while (nowNode.next != null) {
                nowNode = nowNode.next;
            }
            nowNode.next = node;
            node.next = null;
        }
    }

    /**
     * 在指定位置插入节点
     * @param index
     * @param node
     */
    public void addNode(int index, ListNode node) {
        if (index==0) {
            ListNode nowNode = head;
            head = node;
            node.next = nowNode;
        }
        if (index>0) {
            //先获取该索引的前一个节点
            ListNode prev = head;
            for (int i=0;i<index-1;i++) {
                prev = prev.next;
            }
            //获取该索引位置节点
            ListNode now = prev.next;
            prev.next = node;
            node.next = now;
        }
    }

    public void printLinkedList(ListNode head) {
        ListNode nowNode = head;
        while (nowNode!=null) {
            System.out.print(nowNode.val + " ");
            nowNode=nowNode.next;
        }
    }
}
