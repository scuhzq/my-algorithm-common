package com.hzq.backtrack;

/**
 * Created by hzq on 2019-12-26.
 */
public class TwoDimArrayFindWord {

	public static void main(String[] args) {
		char[][] board = {{'A','B','C','E'}, {'S','F','C','S'}, {'A','D','E','E'}};
		String word = "ABCB";
		System.out.println(new TwoDimArrayFindWord().exist(board, word));
	}

	//成员变量定义
	private int row;
	private int col;
	private boolean[][] used;
	private char[][] board;
	private String word;
	private int[][] direction = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

	public boolean exist(char[][] board, String word){
		//初始化、构造
		if(board == null || word == null || "".equals(word) || board[0].length <= 0){
			return false;
		}
		this.row = board.length;
		this.col = board[0].length;
		this.board = board;
		this.used = new boolean[row][col];
		this.word = word;

		//遍历
		for(int i = 0; i < row; i++){
			for (int j = 0; j < col; j++){
				if(dfs(i, j, 0)){
					return true;
				}
			}
		}
		return false;
	}

	private boolean dfs(int i, int j, int start) {
		if(start == word.length() - 1){
			return board[i][j] == word.charAt(start);
		}

		//当前值相等时，才继续
		if(board[i][j] == word.charAt(start)){
			used[i][j] = true;
			//四个方向搜索下一个
			for (int k = 0; k < direction.length; k++){
				int newX = i + direction[k][0];
				int newY = j + direction[k][1];
				if(valid(newX, newY) && !used[newX][newY]){
					if(dfs(newX, newY, start + 1)){
						return true;
					}
				}
			}
			used[i][j] = false;
		}

		return false;
	}

	private boolean valid(int x, int y) {
		return x >= 0 && x < row && y >= 0 && y < col;
	}

}
