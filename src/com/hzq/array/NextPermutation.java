package com.hzq.array;

/**
 * Created by hzq on 2019-12-24.
 */
public class NextPermutation {

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2};
		new NextPermutation().nextPermutation(nums);
		for (int item : nums){
			System.out.print(item + " ");
		}
	}

	private void nextPermutation(int[] nums){
		if(nums == null || nums.length <= 1) return;
		int i = nums.length - 2;
		//找到第一个非降序的索引
		while (i >= 0 && nums[i+1] <= nums[i]){
			i--;
		}
		if(i >= 0){
			int j = nums.length - 1;
			//找到第一个比i大的索引
			while (j >= 0 && nums[j] <= nums[i]){
				j--;
			}
			//交换i和j
			swap(i, j, nums);
		}
		//从i+1往后翻转
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
		if(i == j) return;
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
	}
}
