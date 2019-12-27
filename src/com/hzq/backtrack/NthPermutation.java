package com.hzq.backtrack;

/**
 * Created by hzq on 2019-12-24.
 */
public class NthPermutation {

	public static void main(String[] args) {
		System.out.println(new NthPermutation().getPermutation(4, 9));
	}

	public String getPermutation(int n, int k) {
		if(n <= 0 || k <= 0) return null;

		int[] target = new int[n];
		for (int i = 1; i <= n; i++){
			target[i-1] = i;
		}

		//target是第一个，下面从第二个开始，到第k个
		for (int i = 2; i <= k; i++){
			nextPermutation(target);
		}
		StringBuilder sb = new StringBuilder();
		for (int item : target){
			sb.append(item);
		}
		return sb.toString();
	}

	private void nextPermutation(int[] nums){
		if(nums == null || nums.length <= 1) return;
		int i = nums.length - 2;
		while (i >= 0 && nums[i+1] <= nums[i]){
			i--;
		}
		if(i >= 0){
			int j = nums.length - 1;
			while (j >= 0 && nums[j] <= nums[i]){
				j--;
			}
			swap(i, j, nums);
		}
		reverse(nums, i+1);
	}
	private void reverse(int[] nums, int start){
		int i = start;
		int j = nums.length - 1;
		while (i < j){
			swap(i, j, nums);
			i++;
			j--;
		}
	}
	private void swap(int i, int j, int[] nums){
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}

}
