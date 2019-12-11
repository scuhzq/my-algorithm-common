package com.hzq.array;

import java.util.Arrays;

public class MaxSubArraySum {

    private static int[] array = {-1, 19, 13, 5, -10, 6, -22};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaxSubArraySum(array)));
    }
    //获取最大子数组和
    public static int[] getMaxSubArraySum(int[] A){
        int[] result = new int[3];
        if(A == null | A.length <= 0) return result;
        int start = 0, end = 0, sum = A[0], temp = sum;
        //使用A[0]最为sum和temp，从1开始遍历，比较temp与0。
        for (int i = 1; i < A.length; i++){
            //如果temp和小于等于0，则更新开始位置。
            if(temp <= 0){
                start = i;
                temp = A[i];
            } else {
                temp += A[i];
            }
            //更新结束位置和sum和。
            if(temp > sum){
                sum = temp;
                end = i;
            }
        }
        result[0] = start;
        result[1] = end;
        result[2] = sum;
        return result;
    }

}
