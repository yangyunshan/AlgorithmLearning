package com.yys.LinkedList;

public class DoubleLinkedList {
    private DoubleListNode first;
    private DoubleListNode last;
    private int size;

    public DoubleLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void removeNode(int index) {
        if (index == 0) {
            DoubleListNode node = getNode(index);
            DoubleListNode next = node.next;
            first = next;
            next.prev = null;
            size--;
        }
        else if (index ==size-1) {
            DoubleListNode curr = getNode(index);
            DoubleListNode prev = curr.prev;
            last = prev;
            prev.next = null;
            size--;
        } else {
            DoubleListNode curr = getNode(index);
            curr.prev.next = curr.next;
            curr.next.prev = curr.prev;
            size--;
        }

    }

    /**
     * 在链表末尾添加
     * @param node
     */
    public void add(DoubleListNode node) {
        add(size, node);
    }

    /**
     * 在指定索引位置添加节点
     * @param index
     * @param node
     */
    public void add(int index, DoubleListNode node) {
        //兼容链表为空的情况
        if (size==0) {
            node.next = null;
            node.prev = null;
            first = node;
            last = node;
            size++;
        }
        //在链表头部添加
        else if (index == 0) {
            DoubleListNode curr = first;
            node.next = curr;
            node.prev = null;
            curr.prev = node;
            first = node;
            size++;
        }
        //在链表末尾添加
        else if (index == size) {
            DoubleListNode curr = last;
            node.next = null;
            node.prev = curr;
            curr.next = node;
            last = node;
            size++;
        }
        else {
            DoubleListNode curr = getNode(index);
            DoubleListNode prev = curr.prev;
            prev.next = node;
            node.prev = prev;
            node.next = curr;
            curr.prev = node;
            size++;
        }
    }

    /**
     * 获取任意索引位置的节点,兼容链表为空的情况
     * @param index
     * @return
     */
    public DoubleListNode getNode(int index) {
        if (index <= size/2) {
            DoubleListNode curr = first;
            for (int i=0;i<index;i++) {
                curr = curr.next;
            }
            return curr;
        } else {
            DoubleListNode curr = last;
            for (int i=size;i>index+1;i--) {
                curr = curr.prev;
            }
            return curr;
        }
    }

    public void print() {
        DoubleListNode curr = first;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
