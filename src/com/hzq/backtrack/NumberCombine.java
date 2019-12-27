package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by hzq on 2019-12-11.
 */
public class NumberCombine {

	private static Map<String, String> mapping = new HashMap<>();
	static {
		mapping.put("2", "abc");
		mapping.put("3", "def");
		mapping.put("4", "ghi");
		mapping.put("5", "jkl");
		mapping.put("6", "mno");
		mapping.put("7", "pqrs");
		mapping.put("8", "tuv");
		mapping.put("9", "wxyz");
	}

	public static void main(String[] args) {
		System.out.println(opsByQuene("23"));
		System.out.println(new NumberCombine().letterCombinations("23"));
	}

	public List<String> letterCombinations(String digits) {
		if(digits == null || "".equals(digits)){
			return new ArrayList<>();
		}
		List<String> result = new ArrayList<>();
		dfs(digits, 0, "", result);
		return result;
	}

	private static void dfs(String digits, int index, String nowStr, List<String> result){
		if(index == digits.length()){
			result.add(nowStr);
			return;
		}
		String key = String.valueOf(digits.charAt(index));
		String value = mapping.get(key);
		for (int i = 0; i < value.length(); i++){
			dfs(digits, index+1, nowStr + value.charAt(i), result);
		}
	}

	public static List<String> opsByQuene(String digits) {
		LinkedList<String> res = new LinkedList<>();
		if(digits.isEmpty()){
			return res;
		}
		res.add("");

		//第一层根据digits遍历
		for(int i = 0; i<digits.length(); i++){
			String key = String.valueOf(digits.charAt(i));
			String value = mapping.get(key);

			//队列首部元素的length与当前遍历index一致
			while(res.peek().length() == i){
				String head = res.remove();
				for(char s : value.toCharArray())
					res.add(head + s);
			}
		}

		return res;
	}

}
