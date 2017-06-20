package com.ze.offer;

import java.util.Stack;

import org.junit.Test;

class 栈的压入压出序列 {
	Stack<Integer> assistStack = new Stack<>();

	public boolean isSeq(int[] pPush, int[] pPop, int length) {
		assistStack.push(pPush[0]);
		int j = 1;
		for (int i = 0; i < pPop.length; i++) {

			while (pPop[i] != assistStack.peek() && j < pPush.length) {
				assistStack.push(pPush[j]);
				j++;
			}
			if (assistStack.peek() == pPop[i])
				assistStack.pop();
			else if (j >= pPush.length) {
				return false;
			}
		}
		return assistStack.empty();

	}

	@Test
	public void Test() {
		int[] pPush = { 1, 2, 3, 4, 5 };
		int[] pPop = { 4, 5, 3, 2, 1 };
		System.out.println(isSeq(pPush, pPop, 5));
	}
}