package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by hzq on 2019-11-29.
 */
public class ArrayTargetSum {

	private static int[] array = new int[]{10, 1, 2, 7, 6, 1, 5};
	private static int target = 8;

	public static void main(String[] args) {
		combinationSum2(array, target);
	}

	/**
	 * 一个dfs函数，最终解的list，当前解的list，递归传值相减
	 * 每一次递归调用结束，都回溯，去掉最后一个元素尝试其他元素
	 */
	public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
		//1.定义解空间。目标为target===0。
		//2.每次加入候选集当前值后面的数。
		//3.用start控制搜索的路径。
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> nowList = new ArrayList<>() ;
		Arrays.sort(candidates);
		dfs2(candidates, target, 0, result, nowList);
		print(result);
		return result;
	}

	/**
	 * 2。组合总和。candidates正整数、元素不能重复被选取、解集中无重复
	 */
	public static void dfs2(int[] candidates, int target, int start, List<List<Integer>> result,
	                        List<Integer> nowList){
		if(target < 0){
			return;
		} else if(target == 0){
			result.add(new ArrayList<>(nowList));
			return;
		} else {
			for (int i = start; i < candidates.length; i++){
				int temp = candidates[i];
				//从start+1开始，与前一个对比，如果相等则跳过
				if(i > start && temp == candidates[i - 1]){
					continue;
				}
				nowList.add(temp);
				//因为元素不可以重复被选取，所以index为 i + 1
				dfs2(candidates, target - temp, i + 1, result, nowList);
				nowList.remove(nowList.size() - 1);//回溯移除最后一个
			}
		}
	}

	/**
	 * 1。组合总和。candidates正整数、可以重复被选取、解集中无重复
	 */
	public static void dfs1(int[] candidates, int target, int index, List<List<Integer>> result, List<Integer> nowList){
		if(target < 0){
			return;
		} else if(target == 0){
			result.add(new ArrayList<>(nowList));
			return;
		} else {
			for (int i = index; i < candidates.length; i++){
				int temp = candidates[i];
				nowList.add(temp);
				//因为元素可以重复被选取，所以index仍然传 i
				dfs1(candidates, target - temp, i, result, nowList);
				nowList.remove(nowList.size() - 1);//回溯移除最后一个
			}
		}
	}

	private static void print(List<List<Integer>> result){
		for (List<Integer> list : result){
			System.out.print(list.toString());
			System.out.println();
		}
	}

}
