package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by hzq on 2019-12-31.
 */
public class PalindromePartition {

	public static void main(String[] args) {
		System.out.println(new PalindromePartition().partition("aab"));
	}

	private String str;
	private List<List<String>> result = new LinkedList<>();

	public List<List<String>> partition(String str) {
		//边界条件判断
		if(str == null || "".equals(str.trim())){
			return result;
		}
		this.str = str;
		dfs(new LinkedList<>(), 0);
		return result;
	}

	private void dfs(LinkedList<String> nowList, int start) {
		//递归结束条件
		if(start == str.length()){
			result.add(new ArrayList<>(nowList));
			return;
		}
		for (int i = start; i < str.length(); i++){
			//从start->i,所以需要end = i+1
			String temp = str.substring(start, i + 1);
			if(isPalindrome(temp)){
				nowList.add(temp);
				dfs(nowList, i + 1);
				nowList.removeLast();
			}
		}
	}

	private boolean isPalindrome(String str){
		if(str == null || "".equals(str.trim())){
			return false;
		}
		boolean result = true;
		int right = str.length() - 1;
		int left = 0;
		while (left < right){
			if(str.charAt(left) != str.charAt(right)){
				result = false;
				break;
			}
			left++;
			right--;
		}
		return result;
	}

}
