package com.ze.offer;

/**
 * 
 * @author ZEN 题目：将一段字符串中的每2k个字符中的前k个字符反转
 */
public class ReversString2 {

	public String reverseStr(String s, int k) {
		char[] arr = s.toCharArray();
		int n = arr.length;
		int i = 0;
		while (i < n) {
			int j = Math.min(i + k - 1, n - 1);
			swap(arr, i, j);
			i += 2 * k;
		}
		return String.valueOf(arr);
	}

	private void swap(char[] arr, int l, int r) {
		while (l < r) {
			char temp = arr[l];
			arr[l++] = arr[r];
			arr[r--] = temp;
		}
	}
}		