package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzq on 2019-12-24.
 */
public class NumberCombination {

	private List<List<Integer>> result = new ArrayList<>();
	private int n;
	private int k;

	public List<List<Integer>> combine(int n, int k) {
		if (n <= 0 || k <= 0 || n < k) {
			return result;
		}
		this.n = n;
		this.k = k;
		dfs(1, new ArrayList<>());
		return result;
	}

	private void dfs(int index, List<Integer> nowList) {
		if (nowList.size() == k) {
			result.add(new ArrayList<>(nowList));
			return;
		}

		for (int i = index; i < n + 1; i++) {
			nowList.add(i);
			dfs(i + 1, nowList);
			nowList.remove(nowList.size() - 1);
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> lists = new NumberCombination().combine(4, 2);
		System.out.println(lists);
	}
}
