package com.hzq.tree;

/**
 * Created by hzq on 2020-01-06.
 */
public class Trie {

	public static void main(String[] args) {
		Trie trie = new Trie();

		trie.insert("bad");
		trie.insert("dad");
		trie.insert("mad");
		System.out.println(trie.searchWithDot("pad"));   // 返回 false
		System.out.println(trie.searchWithDot("bad"));     // 返回 true
		System.out.println(trie.searchWithDot(".ad"));     // 返回 true
		System.out.println(trie.searchWithDot("..d"));     // 返回 true
	}

	private TrieNode root;

	public Trie(){
		root = new TrieNode();
	}

	public boolean searchWithDot(String word){
		if(word == null || "".equals(word.trim())){
			return false;
		}
		return dfs(root, word, 0);
	}
	private boolean dfs(TrieNode cur, String word, int start){
		//递归退出条件
		if(start == word.length()){
			return true;
		}
		char ch = word.charAt(start);
		if(ch == '.'){
			for (int i = 0; i < cur.children.length; i++){
				if(cur.children[i] != null && dfs(cur.children[i], word, start + 1)){
					return true;
				}
			}
			return false;
		} else {
			if(cur.get(ch) == null){
				return false;
			}
			return dfs(cur.get(ch), word, start + 1);
		}

	}

	//针对word的每一个字符，insert
	public void insert(String word){
		if(word == null || "".equals(word.trim())){
			return;
		}
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++){
			char ch = word.charAt(i);
			if(!curNode.containsKey(ch)){
				curNode.put(ch, new TrieNode());
			}
			curNode = curNode.get(ch);
		}
		curNode.setEnd(true);
	}

	//前缀查找
	public TrieNode searchPrefix(String word){
		if(word == null || "".equals(word.trim())){
			return null;
		}
		TrieNode curNode = root;
		for (int i = 0; i < word.length(); i++){
			char ch = word.charAt(i);
			if(!curNode.containsKey(ch)){
				return null;
			}
			curNode = curNode.get(ch);
		}
		return curNode;
	}

	//单词查找
	public boolean search(String word){
		if(word == null || "".equals(word.trim())){
			return false;
		}
		TrieNode node = searchPrefix(word);
		return node != null && node.getEnd();
	}

	public boolean startWith(String word){
		if(word == null || "".equals(word.trim())){
			return false;
		}
		TrieNode node = searchPrefix(word);
		return node != null;
	}

	class TrieNode{
		public TrieNode[] children;
		public boolean end;
		private final int R = 26;

		public TrieNode(){
			this.children = new TrieNode[R];
		}

		//ch - 'a'表示在本节点的哪一叉
		public boolean containsKey(char ch){
			return children[ch - 'a'] != null;
		}
		public void put(char ch, TrieNode node){
			children[ch - 'a'] = node;
		}
		public TrieNode get(char ch){
			return children[ch - 'a'];
		}
		public void setEnd(boolean end){
			this.end = end;
		}
		public boolean getEnd(){
			return this.end;
		}
	}

}
