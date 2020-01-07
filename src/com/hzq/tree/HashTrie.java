package com.hzq.tree;

import java.util.HashMap;

/**
 * Created by hzq on 2020-01-06.
 */
public class HashTrie {

	public static void main(String[] args) {
		HashTrie trie = new HashTrie();
//		trie.insert("apple");
//		trie.insert("app");
//
//		System.out.println(trie.search("apple"));
//		System.out.println(trie.search("app"));
//		System.out.println(trie.search("appd"));

		trie.insert("bad");
		trie.insert("dad");
		trie.insert("mad");
		System.out.println(trie.searchWithDot("pad"));   // 返回 false
		System.out.println(trie.searchWithDot("bad"));     // 返回 true
		System.out.println(trie.searchWithDot(".ad"));     // 返回 true
		System.out.println(trie.searchWithDot("..d"));     // 返回 true
	}

	private HashTrieNode root;
	public HashTrie(){
		this.root = new HashTrieNode();
	}

	class HashTrieNode{
		public HashMap<Character, HashTrieNode> children;
		public boolean end;//是否是单词结尾
		public HashTrieNode(){
			this.children = new HashMap<>();
		}
	}

	public boolean searchWithDot(String word){
		if(word == null || "".equals(word.trim())){
			return false;
		}
		return dfs(root, word, 0);
	}
	private boolean dfs(HashTrieNode cur, String word, int start){
		//递归退出条件
		if(start == word.length()){
			return cur.end;
		}
		char ch = word.charAt(start);
		if(ch == '.'){
			for (Character key : cur.children.keySet()){
				if(dfs(cur.children.get(key), word, start + 1)){
					return true;
				}
			}
			return false;
		} else {
			if(cur.children.get(ch) == null){
				return false;
			}
			return dfs(cur.children.get(ch), word, start + 1);
		}

	}

	public void insert(String word){
		if(word == null || "".equals(word.trim())){
			return;
		}
		HashTrieNode cur = root;
		for (int i = 0; i < word.length(); i++){
			char ch = word.charAt(i);
			if(!cur.children.containsKey(ch)){
				cur.children.put(ch, new HashTrieNode());
			}
			cur = cur.children.get(ch);
		}
		if(!cur.end){
			cur.end = true;
		}
	}
	public boolean search(String word){
		HashTrieNode cur = searchPrefix(word);
		//是否以单词结尾
		return cur != null && cur.end;
	}
	public HashTrieNode searchPrefix(String word){
		if(word == null || "".equals(word.trim())){
			return null;
		}
		HashTrieNode cur = root;
		for (int i = 0; i < word.length(); i++){
			char ch = word.charAt(i);
			if(!cur.children.containsKey(ch)){
				return null;
			}
			cur = cur.children.get(ch);
		}
		return cur;
	}
	public boolean startWith(String word){
		return searchPrefix(word) != null;
	}
}
