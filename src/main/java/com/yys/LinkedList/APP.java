package com.yys.LinkedList;

public class APP {
    public static void main(String[] args) {
//        new APP().testCycleLinkedList();
        new APP().testDoubleLinkedList();
    }


    public void testLinkedList() {
        LinkedList linkedList = new LinkedList();


        //生成12345链表结构
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        linkedList.addNode(node1);
        linkedList.addNode(node2);
        linkedList.addNode(node3);
        linkedList.addNode(node4);
        linkedList.addNode(node5);

        //在链表中间根据索引插入节点
        ListNode node6 = new ListNode(6);
        linkedList.addNode(2,node6);

        //打印节点值
        System.out.println("输出链表值：");
        linkedList.printLinkedList(linkedList.getHead());
        System.out.println();

        //根据节点值删除节点
        _237_DeleteNode deleteNode = new _237_DeleteNode();
        deleteNode.deleteNode(node2);
        System.out.println("删除节点后的值：");
        linkedList.printLinkedList(linkedList.getHead());
        System.out.println();

        System.out.println("该链表是否有环：");
        System.out.println(new _141_HasCycle().hasCycle(linkedList.getHead()));
    }

    public void testCycleLinkedList() {
        CycleLinkedList cycleLinkedList = new CycleLinkedList();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);

        cycleLinkedList.add(node1);
        cycleLinkedList.add(node2);
        cycleLinkedList.add(node3);
        cycleLinkedList.add(node4);
        cycleLinkedList.add(node5);

        cycleLinkedList.printList();
        System.out.println("--------------------------------");

        ListNode node6 = new ListNode(6);
        cycleLinkedList.add(2,node6);
        cycleLinkedList.printList();

        System.out.println("---------------------------------");
        cycleLinkedList.removeNode(2);
        cycleLinkedList.printList();

    }

    public void testDoubleLinkedList() {
        DoubleLinkedList doubleLinkedList = new DoubleLinkedList();
        DoubleListNode node1 = new DoubleListNode(1);
        DoubleListNode node2 = new DoubleListNode(2);
        DoubleListNode node3 = new DoubleListNode(3);
        DoubleListNode node4 = new DoubleListNode(4);
        DoubleListNode node5 = new DoubleListNode(5);

        doubleLinkedList.add(node1);
        doubleLinkedList.add(node2);
        doubleLinkedList.add(node3);
        doubleLinkedList.add(node4);
        doubleLinkedList.add(node5);
        doubleLinkedList.print();
        System.out.println("----------------------------------");

        DoubleListNode node6 = new DoubleListNode(6);
        doubleLinkedList.add(0, node6);
        doubleLinkedList.print();
        System.out.println("----------------------------------");

        doubleLinkedList.removeNode(4);
        doubleLinkedList.print();
    }
}
