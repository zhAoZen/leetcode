package com.ze.offer;

import java.util.Stack;

import org.junit.Test;

class 包含min函数的栈 {
	Stack<Integer> dataStack = new Stack<>();
	Stack<Integer> minStack = new Stack<>();

	public void pop() {
		if (dataStack.size() > 0 && minStack.size() > 0) {
			dataStack.pop();
			minStack.pop();
		}
	}

	public void push(int num) {
		dataStack.push(num);
		if (minStack.size() == 0 || num < minStack.peek())
			minStack.push(num);
		else
			minStack.push(minStack.peek());
	}

	public int min() {
		if (dataStack.size() > 0 && minStack.size() > 0) {
			return minStack.peek();
		} else
			return -1;
	}
	@Test
	public void Test(){
		包含min函数的栈 s=new 包含min函数的栈();
		s.push(1);
		System.out.println(s.min());
		s.pop();
		s.push(3);
		s.push(5);
		System.out.println(s.min());
		s.push(0);
		System.out.println(s.min());
	}
}
