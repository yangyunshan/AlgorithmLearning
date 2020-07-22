package com.yys.stack;

import java.util.Stack;

/**
 * 155. 最小栈
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 */
public class _155_Stack {
    Stack<Integer> stack;
    /** initialize your data structure here. */
    public _155_Stack() {
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        int result = 0;
        if (!stack.empty()) {
            result = stack.peek();
            for (int i=0;i<stack.size();i++) {
                if (stack.pop()<result) {
                    result = stack.pop();
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        _155_Stack stack = new _155_Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.top());
    }
}
