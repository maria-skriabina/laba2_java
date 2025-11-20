package com.example;

import java.util.ArrayList;
import java.util.List;

public class Trie {
    private static final int ALPHABET = 26;
    private final TrieNode root;

    private static class TrieNode {
        TrieNode[] children = new TrieNode[ALPHABET];
        boolean isWord;
    }

    public Trie() {
        root = new TrieNode();
    }

    private int charToIndex(char c) {
        if (c >= 'a' && c <= 'z') return c - 'a';
        if (c >= 'A' && c <= 'Z') return c - 'A';
        return -1;
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = charToIndex(c);
            if (idx == -1) throw new IllegalArgumentException("Only English letters allowed!");
            if (node.children[idx] == null)
                node.children[idx] = new TrieNode();
            node = node.children[idx];
        }
        node.isWord = true;
    }

    public boolean contains(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            int idx = charToIndex(c);
            if (idx == -1 || node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return node.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode node = root;
        for (char c : prefix.toCharArray()) {
            int idx = charToIndex(c);
            if (idx == -1 || node.children[idx] == null) return false;
            node = node.children[idx];
        }
        return true;
    }

    public List<String> getByPrefix(String prefix) {
        List<String> result = new ArrayList<>();
        TrieNode node = root;

        for (char c : prefix.toCharArray()) {
            int idx = charToIndex(c);
            if (idx == -1 || node.children[idx] == null) return result;
            node = node.children[idx];
        }

        dfs(node, new StringBuilder(prefix), result);
        return result;
    }

    private void dfs(TrieNode node, StringBuilder sb, List<String> result) {
        if (node.isWord) result.add(sb.toString());
        for (int i = 0; i < ALPHABET; i++) {
            if (node.children[i] != null) {
                sb.append((char) ('a' + i));
                dfs(node.children[i], sb, result);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}