package com.bytedance.pia.core.misc;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;

/* loaded from: classes4.dex */
public class Trie<T, V> {
    private final Trie<T, V>.TrieNode root = new TrieNode();
    private final T wildcard;

    public Trie(T t) {
        this.wildcard = t;
    }

    public void insert(Iterable<T> iterable, V v) {
        Trie<T, V>.TrieNode trieNode = this.root;
        Iterator<T> it = iterable.iterator();
        while (it.hasNext()) {
            trieNode = trieNode.getOrNewChild(it.next());
        }
        trieNode.setWordEnd(v);
    }

    public V search(List<T> list) {
        Trie<T, V>.TrieNode child;
        if (list.isEmpty()) {
            return null;
        }
        Stack stack = new Stack();
        stack.push(new SearchInfo(this.root, 0));
        while (!stack.isEmpty()) {
            SearchInfo searchInfo = (SearchInfo) stack.pop();
            int i = searchInfo.index;
            if (i == list.size()) {
                if (searchInfo.node.isWordEnd()) {
                    return searchInfo.node.getDetails();
                }
            } else {
                T t = list.get(i);
                if (this.wildcard != null && (child = searchInfo.node.getChild(this.wildcard)) != null) {
                    stack.push(new SearchInfo(child, i + 1));
                }
                Trie<T, V>.TrieNode child2 = searchInfo.node.getChild(t);
                if (child2 != null) {
                    stack.push(new SearchInfo(child2, i + 1));
                }
            }
        }
        return null;
    }

    /* loaded from: classes4.dex */
    private class TrieNode {
        private final Map<T, Trie<T, V>.TrieNode> children;
        private V details;

        private TrieNode() {
            this.children = new HashMap();
            this.details = null;
        }

        public Trie<T, V>.TrieNode getChild(T t) {
            return this.children.get(t);
        }

        public Trie<T, V>.TrieNode getOrNewChild(T t) {
            Trie<T, V>.TrieNode trieNode = this.children.get(t);
            if (trieNode != null) {
                return trieNode;
            }
            Trie<T, V>.TrieNode trieNode2 = new TrieNode();
            this.children.put(t, trieNode2);
            return trieNode2;
        }

        public boolean isWordEnd() {
            return this.details != null;
        }

        public void setWordEnd(V v) {
            this.details = v;
        }

        public V getDetails() {
            return this.details;
        }
    }

    /* loaded from: classes4.dex */
    private class SearchInfo {
        public final int index;
        public final Trie<T, V>.TrieNode node;

        public SearchInfo(Trie<T, V>.TrieNode trieNode, int i) {
            this.node = trieNode;
            this.index = i;
        }
    }
}
