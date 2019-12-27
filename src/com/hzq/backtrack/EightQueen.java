package com.hzq.backtrack;

/**
 * Created by hzq on 2019-11-29.
 * 不能在同一行、同一列、同一斜线
 */
public class EightQueen {

	private int maxRow = 8;
	private int maxCol = 8;
	private int[][] board = new int[maxRow][maxCol];
	private int total = 0;

	public static void main(String[] args) {
		new EightQueen().calQueen(0);
	}

	/**
	 * 递归回溯
	 */
	public void calQueen(int row){
		if(row >= maxRow){
			total++;
			System.out.println("找到一个解，当前total:" + total);
			print();
			return;
		}

		//在第row行，每个格子来check
		for(int col = 0; col < maxCol; col++){
			if(check(row, col)){//校验该位置是否合法
				board[row][col] = 1;//合法设置为1
				calQueen(row + 1);//递归下一层
				board[row][col] = 0;//失败回退为0
			}
		}
	}

	/**
	 * check当前位置是否符合条件
	 */
	public boolean check(int row, int col){
		//因为是一行一行放置。所以只需要校验 col不动row--; row-- col--; row-- col++

		//row--
		for(int i = row - 1; i >= 0; i--){
			if(board[i][col] == 1) return false;
		}

		//row--,col--
		for (int i=row-1,j=col-1; i >=0 && j>=0; i--,j--){
			if(board[i][j] == 1) return false;
		}

		//row--,col++
		for (int i=row-1,j=col+1; i>=0 && j<maxCol; i--,j++){
			if(board[i][j] == 1) return false;
		}
		return true;
	}

	public void print(){
		for (int i = 0; i< maxRow; i++){
			for (int j = 0; j < maxCol; j++){
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}
}
