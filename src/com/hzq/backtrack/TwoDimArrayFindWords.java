package com.hzq.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hzq on 2020-01-02.
 */
public class TwoDimArrayFindWords {

	public static void main(String[] args) {
//		char[][] board = {{'o','a','a','n'},{'e','t','a','e'},{'i','h','k','r'},{'i','f','l','v'}};
//		String[] words = {"oath","pea","eat","rain"};
		char[][] board = {{'a'},{'b'}};
		String[] words = {"ba"};
		System.out.println(new TwoDimArrayFindWords().find(board, words));
	}

	//成员变量减少递归参数
	private String word;
	private int maxRol;
	private int maxCol;
	private char[][] board;
	private boolean[][] used;
	private List<String> result = new ArrayList<>();
	private int[][] direction = {{-1,0},{0,-1},{1,0},{0,1}};

	public List<String> find(char[][] board, String[] words) {
		//边界条件判断
		if(board == null || board[0] == null || board[0].length <= 0){
			return result;
		}
		if(words == null || words.length <= 0){
			return result;
		}

		//初始化
		this.board = board;
		this.maxRol = board.length;
		this.maxCol = board[0].length;

		//循环判断
		for(int i = 0; i < words.length; i++){
			if(exist(words[i])){
				result.add(words[i]);
			}
		}
		return result;
	}

	private boolean exist(String str){
		if(str == null || "".equals(str.trim())){
			return false;
		}
		//每次重新初始化word和used
		this.word = str;
		this.used = new boolean[maxRol][maxCol];

		//遍历二维数组，比对str
		for(int i = 0; i < maxRol; i++){
			for(int j = 0; j < maxCol; j++){
				if(dfs(i, j, 0)){
					return true;
				}
			}
		}

		return false;
	}

	private boolean dfs(int row, int col, int start){
		//递归结束条件
		if(start == word.length() - 1){
			return board[row][col] == word.charAt(start);
		}

		boolean equal = board[row][col] == word.charAt(start);
		if(!equal){
			return false;
		}

		//四个方向判断
		used[row][col] = true;
		for(int i = 0; i < direction.length; i++){
			int newRow = row + direction[i][0];
			int newCol = col + direction[i][1];
			//如果不合法或者已经被使用，则continue
			if(valid(newRow, newCol) && !used[newRow][newCol]){
				if(dfs(newRow, newCol, start + 1)){
					return true;
				}
			}

		}
		used[row][col] = false;

		return false;
	}

	private boolean valid(int row, int col){
		return row >= 0 && row < maxRol && col >= 0 && col < maxCol;
	}
}
