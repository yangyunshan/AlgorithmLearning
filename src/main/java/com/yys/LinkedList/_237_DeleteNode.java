package com.yys.LinkedList;

public class _237_DeleteNode {

    //思路：将该节点的值替换为下一节点的值，然后把下一节点删除掉即可，因为我们没有办法获取到要删除节点的前一节点
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
