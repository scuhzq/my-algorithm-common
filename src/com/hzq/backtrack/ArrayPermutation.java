package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hzq on 2019-12-20.
 */
public class ArrayPermutation {

	public static void main(String[] args) {
		int[] array = new int[]{1, 2, 3, 1};
		Arrays.sort(array);
		System.out.println(new ArrayPermutation().permute(array));
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		if(nums == null || nums.length <= 0){
			return res;
		}
		List<Integer> nowList = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		dfs(nums, used, nowList, res);
		return res;
	}

	private void dfs(int[] nums, boolean[] used, List<Integer> nowList, List<List<Integer>> res){
		if(nowList.size() == nums.length){
			res.add(new ArrayList<>(nowList));
			return;
		}
		for (int i = 0; i < nums.length; i++){
			if(!used[i]){
				if(i > 0 && nums[i] == nums[i-1] && !used[i-1]) continue;
				nowList.add(nums[i]);
				used[i] = true;
				dfs(nums, used, nowList, res);
				nowList.remove(nowList.size() - 1);
				used[i] = false;
			}
		}
	}

}
