package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/**
 * Created by hzq on 2019-12-16.
 */
public class Bracket {

	public List<String> generate(int n) {
		List<String> res = new ArrayList<>();
		if(n == 0){
			return res;
		}
		dfs("", n, n, res);
		return res;
	}
	private void dfs(String curStr, int left, int right, List<String> res){
		if(left == 0 && right == 0){
			res.add(curStr);
			return;
		}
		if(left > 0){
			dfs(curStr + "(", left - 1, right, res);
		}
		if(right > 0 && right > left){
			dfs(curStr + ")", left, right - 1, res);
		}
	}

	//只包含'('，')'，'{'，'}'，'['，']'
	public boolean validBracket(String str){
		Map<Character, Character> mapping = new HashMap<>();
		mapping.put(')', '(');
		mapping.put('}', '{');
		mapping.put(']', '[');

		if(null == str || "".equals(str)){
			return false;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < str.length(); i++){
			Character c = str.charAt(i);
			if(mapping.containsValue(c)){
				stack.push(c);
			} else {
				Character item = stack.isEmpty() ? '#' : stack.pop();
				if(item != mapping.get(c)){
					return false;
				}
			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		System.out.println(new Bracket().validBracket("]"));
	}

}
