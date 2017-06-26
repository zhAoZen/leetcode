package com.ze.offer;

import org.junit.Test;

public class GetMaxPrepition {
	/**
	 * Q: Define S = [s,n] as the string S which consists of n connected strings
	 * s. For example, ["abc", 3] ="abcabcabc".
	 * 
	 * On the other hand, we define that string s1 can be obtained from string
	 * s2 if we can remove some characters from s2 such that it becomes s1. For
	 * example, “abc” can be obtained from “abdbec” based on our definition, but
	 * it can not be obtained from “acbbe”.
	 * 
	 * You are given two non-empty strings s1 and s2 (each at most 100
	 * characters long) and two integers 0 ≤ n1 ≤ 106 and 1 ≤ n2 ≤ 106. Now
	 * consider the strings S1 and S2, where S1=[s1,n1] and S2=[s2,n2]. Find the
	 * maximum integer M such that [S2,M] can be obtained from S1.
	 * 
	 * A:1.How do we know "string s2 can be obtained from string s1"? 
	 * Easy, use two pointers iterate through s2 and s1. If chars are equal, move both.
	 * Otherwise only move pointer1. 
	 * 2.We repeat step 1 and go through s1 for n1 times and count how many times can we go through s2. 
	 * 3.Answer to this problem is times go through s2 divide by n2.
	 * 
	 * @param s1
	 * @param n1
	 * @param s2
	 * @param n2
	 * @return
	 */
	public int getMaxRepetitions(String s1, int n1, String s2, int n2) {
		// abab acbacbacbacb
		// acb 4 ab 2
		char[] array1 = s1.toCharArray();
		char[] array2 = s2.toCharArray();
		int count1 = 0, count2 = 0, i = 0, j = 0;
		while (count1 < n1) {// 当累计次数小于n1
			if (array2[i] == array1[j]) {
				i++;
			}
			j++;
			if (j == array1.length) {// 当已经循环过一次s1
				count1++;
				j = 0;
			}
			if (i == array2.length) {// 已经循环过一次s2
				i = 0;
				count2++;
			}
		}

		return count2 / n2;
	}

	@Test
	public void Test() {
		String s1 = "acb";
		String s2 = "ab";
		System.out.println(getMaxRepetitions(s1, 4, s2, 2));
	}
}
