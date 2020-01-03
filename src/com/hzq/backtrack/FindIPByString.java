package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzq on 2019-12-27.
 */
public class FindIPByString {

	public static void main(String[] args) {
		System.out.println(new FindIPByString().findValidIp("25525511135"));
	}

	//成员变量
	private List<String> result = new ArrayList<>();
	private String str;
	private int len;

	public List<String> findValidIp(String s) {
		//边界条件判断
		if(s == null || "".equals(s.trim())){
			return result;
		}
		//成员变量赋值
		this.str = s;
		this.len = s.length();
		if(len < 4 || len > 16){
			return result;
		}

		//从index为0开始遍历，flag代表dot的个数
		backtrack(0, "", 4);

		return result;
	}

	private void backtrack(int start, String nowStr, int flag) {
		//递归结束条件
		if (start == len && flag == 0) {
			result.add(nowStr.substring(0, nowStr.length() - 1));
			return;
		}
		if (flag < 0){
			return;
		}

		//遍历3个数字，从start、start+1、start+2
		for (int k = start; k < start + 3 && k < len; k++) {
			//判断特殊值'0'，且位于start位置
			if (k == start && str.charAt(k) == '0') {
				backtrack(k + 1, nowStr + str.charAt(k) + ".", flag - 1);
				break;
			}
			//[start, k]判断合法性
			if (Integer.parseInt(str.substring(start, k + 1)) <= 255){
				backtrack(k + 1, nowStr + str.substring(start, k + 1) + ".", flag - 1);
			}
		}
	}
}
