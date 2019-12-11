package com.hzq.search;

public class ArrayBinarySearch {

    public static void main(String[] args) {
        System.out.println(circleSearch(circleA, 1));
    }

    //循环递增数组查找
    private static int[] circleA = {5, 8, 9, 10, 12, -2, 1, 3, 4};//循环递增
    private static int circleSearch(int[] A, int key){
        int start = 0;
        int end = circleA.length - 1;
        int mid;
        while (start <= end){
            mid = (start + end) / 2;
            if(circleA[mid] == key) return mid;
            //说明左边递增，右边循环递增
            if(circleA[start] <= circleA[mid]){
                if(key >= circleA[start] && key <= circleA[mid]){
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            //左边循环递增，右边递增
            } else {
                if(key >= circleA[mid] && key <= circleA[end]){
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }


    //二分查找
    private static int[] A = {-5, -4, -2, -1, 0, 1, 3, 4, 6, 7};//有序
    //如果存在则返回索引，否则返回比它大的index
    private static int binarySearch(int[] A, int key){
        int start = 0;
        int end = A.length - 1;
        int mid = -1;
        while (start <= end){
            mid = (start + end) / 2;
            if(A[mid] == key){
                return mid;
            } else if(A[mid] > key){
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        if(A[mid] > key){
            return mid;
        } else {
            return mid + 1;
        }
    }

}
