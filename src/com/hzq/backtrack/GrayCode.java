package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzq on 2019-12-27.
 */
public class GrayCode {

	public static void main(String[] args) {
		System.out.println(new GrayCode().grayCode(3));
	}

	/**
	 * 1位的格雷码0、1
	 * n+1位的格雷码，前一半为n位格雷码，顺序书写，加前缀0(不影响int型数字)
	 * n+1位的格雷码，后一半为n位格雷码，逆序书写，加前缀1(即2的n次方)
	 */
	public List<Integer> grayCode(int n) {
		List<Integer> result = new ArrayList<>();
		if(n <= 0) return result;

		//初始化1位格雷码
		result.add(0);
		result.add(1);
		if(n == 1){
			return result;
		}

		//借助前面计算的值，使用动态规划
		for (int i = 2; i <= n; i++){
			//n位格雷码，需要 1<< n - 1位
			int add = 1 << (i - 1);
			for (int j = result.size() - 1; j >= 0; j--){
				result.add(result.get(j) + add);
			}
		}

		return result;
	}

}
