package com.yys.LinkedList;

public class CycleLinkedList {
    private ListNode head;
    private int size;

    public CycleLinkedList() {
        head = null;
        size = 0;
    }

    public void removeNode(int index) {
        //移除0索引的节点
        if (index == 0) {
            ListNode next = getNode(index + 1);
            ListNode last = getNode(size);
            head = next;
            last.next = next;
            size--;
        }
        ListNode prev = getNode(index - 1);
        prev.next = prev.next.next;
        size--;
    }

    /**
     * 向链表尾部添加节点
     * @param node
     */
    public void  add(ListNode node) {
        add(size, node);
    }

    /**
     * 向循环链表中添加节点
     * @return
     */
    public void add(int index, ListNode node) {
        //在链表头部添加节点
        if (index == 0) {
            if (size == 0) {
                head = node;
                node.next = node;
            }
            ListNode curr = head;
            ListNode last = getNode(size-1);
            head = node;
            node.next = curr;
            last.next = node;
            size++;
        }
        //在链表末尾添加节点
        else if (index == size) {
            ListNode curr = getNode(index-1);
            curr.next = node;
            node.next = head;
            size++;
        }
        //在链表中间插入节点
        else {
            //curr为该索引下的节点
            //prev为该索引节点的前一个节点
            ListNode prev = getNode(index-1);
            ListNode curr = getNode(index);
            curr = prev.next;
            prev.next = node;
            node.next = curr;
            size++;
        }
    }

    /**
     * 获取该索引位置的节点
     * @param index
     * @return
     */
    public ListNode getNode(int index) {
        ListNode curr = head;
        if (index == 0) {
            return curr;
        }
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void printList() {
        if (head != null) {
            ListNode curr = head;
            for (int i=0; i<size; i++) {
                System.out.println(curr.val);
                curr = curr.next;
            }
        }
    }
}
