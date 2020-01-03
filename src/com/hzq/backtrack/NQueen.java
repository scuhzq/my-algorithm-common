package com.hzq.backtrack;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by hzq on 2019-12-31.
 */
public class NQueen {

	public static void main(String[] args) {
		NQueen nQueen = new NQueen();
		System.out.println(nQueen.solveNQueens(4));
		System.out.println("total:" + nQueen.total);
	}

	private int n;
	private boolean[][] board;
	List<List<String>> result = new LinkedList<>();
	private int total = 0;

	public List<List<String>> solveNQueens(int n) {
		if(n <= 0){
			return result;
		}
		this.n = n;
		this.board = new boolean[n][n];
		dfs(0);
		return result;
	}
	private void dfs(int row){
		if(row == n){
			result.add(addSolution(board));
			total++;
			return;
		}

		for (int col = 0; col < n; col++){
			if(!valid(board, row, col)){
				continue;
			}
			board[row][col] = true;
			dfs(row+1);
			board[row][col] = false;
		}
	}

	private boolean valid(boolean[][] board, int row, int col){
		//遍历左斜线
		for (int i = row, j = col; i >= 0 && j >= 0; i--,j--){
			if (board[i][j] == true){
				return false;
			}
		}
		//遍历右斜线
		for (int i = row, j = col; i >= 0 && j < n; i--,j++){
			if (board[i][j] == true){
				return false;
			}
		}

		//遍历上直线
		for (int i = row; i >= 0; i--){
			if (board[i][col] == true){
				return false;
			}
		}
		return true;
	}

	private List<String> addSolution(boolean[][] board){
		List<String> result = new LinkedList<>();
		for (int i = 0; i < board.length; i++){
			StringBuilder sb = new StringBuilder();
			for (int j = 0; j < board[i].length; j++){
				if(board[i][j]){
					sb.append('Q');
				} else {
					sb.append(".");
				}
			}
			result.add(sb.toString());
		}
		return result;
	}

}
