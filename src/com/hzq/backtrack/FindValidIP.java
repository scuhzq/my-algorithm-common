package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzq on 2019-12-27.
 */
public class FindValidIP {

	public static void main(String[] args) {
		System.out.println(new FindValidIP().find("25525511135"));
	}

	//成员变量
	private int len;
	private String str;
	private List<String> result = new ArrayList<>();

	public List<String> find(String str){
		//边界判断
		if(str == null || "".equals(str.trim())){
			return result;
		}
		this.len = str.length();
		this.str = str;
		if(len < 4 || len > 16){
			return result;
		}

		//递归回溯
		dfs(0, "", 4);

		return result;
	}

	private void dfs(int start, String nowStr, int flag){
		//递归退出条件
		if(start == len && flag == 0){
			//因为最后有 . ，所以需要len - 1
			result.add(nowStr.substring(0, nowStr.length() - 1));
			return;
		}
		if(flag < 0){
			return;
		}

		//从start -> start + 2遍历，回溯
		for (int i = start; i < start + 3 && i < len; i++){
			//判断特殊0
			if(i == start && str.charAt(i) == '0'){
				dfs(i + 1, nowStr + "0.", flag - 1);
				break;
			}
			//判断合法性
			if(Long.valueOf(str.substring(start, i + 1)) <= 255){
				dfs(i + 1, nowStr + str.substring(start, i + 1) + ".", flag - 1);
			}
		}
	}

}
