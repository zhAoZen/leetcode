package com.ze.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

/**
 * 
 * @author ZEN
 *题目：完成一个集合，使其在O(1)时间内完成插入，删除，并可以返回其中的一个随机元素。
 *思路:借助hashmap，HashMap<Integer,LinkedHashSet<Interger>>，其中LinkedHashSet中储存数字的存放下标。
 *插入：若未包含，则在hashmap中存放当前数字，并新建下标列表；若已经存在，则在hashmap中添加数字对应的下标至下标列表中。
 *删除：判断是否已被包含，若未，则直接返回false。若被包含，获取该数字的下标，并在hashmap中将该下标删除。将最后一个数字改到被删除元素的位置，并更新hashmap。最后将ArrayList中的最后一个元素删除即可。这样，只需要O(1)的时间就可以完成删除
 */
public class RandomizedCollection {
	ArrayList<Integer> nums;
	HashMap<Integer, Set<Integer>> locs;
	java.util.Random rand = new java.util.Random();

	/** Initialize your data structure here. */
	public RandomizedCollection() {
		nums = new ArrayList<Integer>();
		locs = new HashMap<Integer, Set<Integer>>();
	}

	/**
	 * Inserts a value to the collection. Returns true if the collection did not
	 * already contain the specified element.
	 */
	public boolean insert(int val) {
		boolean contain = locs.containsKey(val);
		if (!contain)
			locs.put(val, new LinkedHashSet<Integer>());
		locs.get(val).add(nums.size());
		nums.add(val);
		return !contain;
	}

	/**
	 * Removes a value from the collection. Returns true if the collection
	 * contained the specified element.
	 */
	public boolean remove(int val) {
		boolean contain = locs.containsKey(val);
		if (!contain)
			return false;
		int loc = locs.get(val).iterator().next();
		locs.get(val).remove(loc);
		if (loc < nums.size() - 1) {
			int lastone = nums.get(nums.size() - 1);
			nums.set(loc, lastone);
			locs.get(lastone).remove(nums.size() - 1);
			locs.get(lastone).add(loc);
		}
		nums.remove(nums.size() - 1);

		if (locs.get(val).isEmpty())
			locs.remove(val);
		return true;
	}

	/** Get a random element from the collection. */
	public int getRandom() {
		return nums.get(rand.nextInt(nums.size()));
	}

	@Test
	public void test() {
		RandomizedCollection rc = new RandomizedCollection();
		rc.insert(1);
		rc.insert(1);
		rc.insert(15);
		rc.remove(1);
		rc.remove(1);
		rc.insert(2);
		rc.remove(3);

	}
}