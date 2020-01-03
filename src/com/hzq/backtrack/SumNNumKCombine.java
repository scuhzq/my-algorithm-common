package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzq on 2019-12-31.
 */
public class SumNNumKCombine {

	private int k;
	private List<List<Integer>> result = new ArrayList<>();
	private int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	private boolean[] used = new boolean[9];

	public static void main(String[] args) {
		System.out.println(new SumNNumKCombine().combinationSum3(3, 9));
	}

	public List<List<Integer>> combinationSum3(int k, int n) {
		if(k <= 0 || k > 9 || n <= 0){
			return result;
		}
		this.k = k;
		List<Integer> nowList = new ArrayList<>();
		dfs(nowList, 0, 0, n);
		return result;
	}

	private void dfs(List<Integer> nowList, int start, int nowK, int nowN){
		if(nowK == k && nowN == 0){
			result.add(new ArrayList<>(nowList));
		}
		for (int i = start; i < array.length; i++){
			int diff = nowN - array[i];
			if(diff < 0){
				return;
			} else {
				if(used[i]){
					continue;
				}
				nowList.add(array[i]);
				used[i] = true;
				dfs(nowList, i + 1, nowK + 1, diff);
				nowList.remove(nowList.size() - 1);
				used[i] = false;
			}
		}
	}

}
