package com.example;

public class TrieMain {

    public static void main(String[] args) {

        System.out.println("=== ТЕСТИРУЕМ TRIE (префиксное дерево) ===");

        Trie trie = new Trie();

        trie.insert("apple");
        trie.insert("app");
        trie.insert("bat");

        System.out.println("\nПроверка наличия слов:");
        System.out.println("contains(\"app\") ? " + trie.contains("app"));
        System.out.println("contains(\"apply\") ? " + trie.contains("apply"));

        System.out.println("\nПроверка наличия слов с префиксом:");
        System.out.println("startsWith(\"ap\") ? " + trie.startsWith("ap"));
        System.out.println("startsWith(\"ba\") ? " + trie.startsWith("ba"));
        System.out.println("startsWith(\"ca\") ? " + trie.startsWith("ca"));

        System.out.println("\nПолучаем слова по префиксу:");
        System.out.println("getByPrefix(\"ap\") ? " + trie.getByPrefix("ap"));

        System.out.println("\n=== ТЕСТ TRIE ЗАВЕРШЕН ===");
    }
}
