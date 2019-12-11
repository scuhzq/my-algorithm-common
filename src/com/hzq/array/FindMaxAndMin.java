package com.hzq;

import java.util.Arrays;

/**
 * 对比1.5n次找到最大最小数
 */
public class FindMaxAndMin {

    private static int[] array = {-1, 19, 13, 5, -10, 6, -22};

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getMaxMin(array)));
    }

    private static int[] getMaxMin(int[] A){
        int[] result = new int[2];
        int max = 0;
        int min = 0;
        int i = 0;
        int j = array.length - 1;
        while (i < j){
            int tempi = array[i++];
            int tempj = array[j--];
            if(tempi <= tempj){
                if(tempj > max){
                    max = tempj;
                }
                if(tempi < min){
                    min = tempi;
                }
            } else {
                if(tempi > max){
                    max = tempi;
                }
                if(tempj < min){
                    min = tempj;
                }
            }
        }

        result[0] = max;
        result[1] = min;
        return result;
    }

}
