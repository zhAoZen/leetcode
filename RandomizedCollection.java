package com.ze.offer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Set;

import org.junit.Test;

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
	public void test(){
		RandomizedCollection rc=new RandomizedCollection();
		rc.insert(1);
		rc.insert(1);
		rc.insert(15);
		rc.remove(1);
		rc.remove(1);
		rc.insert(2);
		rc.remove(3);
		
	}
}