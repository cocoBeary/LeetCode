// 1. Two Sum

// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:

// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

import java.util.HashMap;
import java.util.Map;
public class TwoSum {
	//HashMap
	public int[] twoSum(int[] nums, int target) {
		int[] res=new int[2];
		Map<Integer,Integer> map= new HashMap<>();
		for(int i=0;i<nums.length;i++) {
			if(map.containsKey(target-nums[i])) {
				return new int[]{map.get(target-nums[i]),i};
			} else {
				map.put(nums[i], i);
			}
		}
		
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 2, 7, 11, 15 };
		int target = 9;
		TwoSum test = new TwoSum();
		int[] res=test.twoSum(nums, target);
		System.out.println(res[0]+" "+res[1]);
	}

}
