package com.hzq.array;

public class ArrayPrintOutToInner {

    private static int[][] A = {{1,2,3,4}, {5, 6,7,8}, {9, 10, 11, 12}, {13,14,15,16}};

    public static void main(String[] args) {
        int starRow = 0, endRow = A.length - 1;
        int starColumn = 0, endColumn = A[0].length - 1;
        while (starRow <= endRow && starColumn <= endColumn){
            int i;
            //输出上边行，y不变，x++
            for(i = starColumn; i <= endColumn; i++){
                System.out.print(A[starRow][i] + " ");
            }
            starRow++;
            System.out.println();
            //输出右边行，x不变，y++
            for(i = starRow; i <= endRow; i++){
                System.out.print(A[i][endColumn] + " ");
            }
            endColumn--;
            System.out.println();
            //输出下边行，y不变，x--
            for (i = endColumn; i >= starColumn; i--){
                System.out.print(A[endRow][i] + " ");
            }
            endRow--;
            System.out.println();
            //输出左边行，x不变，y--
            for (i = endRow; i >= starRow; i--){
                System.out.print(A[i][starColumn] + " ");
            }
            starColumn++;
            System.out.println();
        }
    }
}

