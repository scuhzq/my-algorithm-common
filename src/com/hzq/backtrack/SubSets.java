package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hzq on 2019-12-24.
 */
public class SubSets {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 2};
		System.out.println(new SubSets().subsetsCanDupl(nums));
	}

	private List<List<Integer>> result = new ArrayList<>();

	public List<List<Integer>> subsets(int[] nums) {
		if(nums == null || nums.length <= 0) return result;
		dfs(nums, 0, new ArrayList<>());
		return result;
	}

	private void dfs(int[] nums, int start, List<Integer> nowList){
		result.add(new ArrayList<>(nowList));
		for (int i = start; i < nums.length; i++){
			nowList.add(nums[i]);
			dfs(nums, i + 1, nowList);
			nowList.remove(nowList.size() - 1);
		}
	}

	public List<List<Integer>> subsetsCanDupl(int[] nums) {
		if(nums == null || nums.length <= 0) return result;
		Arrays.sort(nums);//排序
		dfs2(nums, 0, new ArrayList<>());
		return result;
	}
	private void dfs2(int[] nums, int start, List<Integer> nowList){
		result.add(new ArrayList<>(nowList));
		for (int i = start; i < nums.length; i++){
			if(i > start && nums[i] == nums[i - 1]){
				continue;
			}
			nowList.add(nums[i]);
			dfs2(nums, i + 1, nowList);
			nowList.remove(nowList.size() - 1);
		}
	}

}
