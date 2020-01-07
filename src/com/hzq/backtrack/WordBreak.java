package com.hzq.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hzq on 2020-01-06.
 */
public class WordBreak {

	private boolean[] dp;
	private LinkedList<String> result = new LinkedList<>();
	private List<String> dict;
	private String word;

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		List<String> dict = new LinkedList<>();
		dict.add("a");
		dict.add("aa");
		dict.add("aaa");
		dict.add("aaaa");
		dict.add("aaaaa");
		dict.add("aaaaaa");
		dict.add("aaaaaaa");
		dict.add("aaaaaaaa");
		dict.add("aaaaaaaaa");
		dict.add("aaaaaaaaaa");
		System.out.println(new WordBreak().wordBreak(s, dict));
	}

	//dp[i]表示s的前ii位是否可以用dict中的单词表示。始化dp[0]=True，空字符可以被表示
	public boolean isBreak(String s, List<String> dict){
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;//dp[i]表示从0到i能否拆分，i为0时，表示空串，字典中不选即可
		for (int i = 1; i <= s.length(); i++){
			for (int j = 0; j < i; j++){
				String subStr = s.substring(j, i);
				//如果存在dp[j]可以拆分，且s[j, i]在字典中，则dp[i]可以拆分
				if(dp[j] && dict.contains(subStr)){
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	public List<String> wordBreak(String s, List<String> dict) {
		if(s == null || "".equals(s.trim()) || dict == null || dict.isEmpty()){
			return result;
		}
		this.word = s;
		this.dict = dict;
		this.dp = new boolean[s.length() + 1];
		dp[0] = true;//dp[i]表示从0到i能否拆分，i为0时，表示空串，字典中不选即可
		for (int i = 1; i <= s.length(); i++){
			for (int j = 0; j < i; j++){
				//如果存在dp[j]可以拆分，且s[j, i]在字典中，则dp[i]可以拆分
				if(dp[j] && dict.contains(s.substring(j, i))){
					dp[i] = true;
					break;
				}
			}
		}
		if(dp[s.length()]){
			dfs(0, "");
		}
		return result;
	}
	public void dfs(int start, String nowStr) {
		if (start == word.length()) {
			result.add(nowStr);
		}
		for (int i = start + 1; i <= word.length(); i++) {
			//使用dp[i]剪枝
			if(dp[i]){
				String subStr = word.substring(start, i);
				if (dict.contains(subStr)) {
					String newStr = nowStr + subStr;
					if(i != word.length()){
						newStr += " ";
					}
					dfs(i, newStr);
				}
			}
		}
	}

}
