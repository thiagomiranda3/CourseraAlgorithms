package br.com.tommiranda.algorithms.trees;

import com.sun.jdi.Value;

import java.util.ArrayDeque;
import java.util.Queue;

public class RedBlackSearchTree<Key extends Comparable<Key>, Value> {

    private ColorNode<Key, Value> root;

    public boolean isRed(ColorNode node) {
        return node != null && node.isRed();
    }

    // Retorna o valor associado à chave armazenada na árvore
    public Value get(Key key) {
        ColorNode<Key, Value> x = root;

        while (x != null) {
            int cmp = key.compareTo(x.getKey());

            if (cmp < 0) {
                x = x.left;
            } else if (cmp > 0) {
                x = x.right;
            } else {
                return x.getValue();
            }
        }

        return null;
    }

    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private ColorNode<Key, Value> put(ColorNode<Key, Value> node, Key key, Value value) {
        if(node == null) {
            return new ColorNode<>(key, value);
        }

        int cmp = key.compareTo(node.getKey());

        if(cmp < 0) {
            node.left = put(node.left, key, value);
        } else if(cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.setValue(value);
        }

        if(isRed(node.right) && !isRed(node.left)) {
            node = rotateLeft(node);
        }

        if(isRed(node.left) && isRed(node.left.left)) {
            node = rotateRight(node);
        }

        if(isRed(node.left) && isRed(node.right)) {
            flipColors(node);
        }

        return node;
    }

    private ColorNode<Key, Value> rotateLeft(ColorNode node) {
        ColorNode x = node.right;
        node.right = x.left;
        x.left = node;
        x.setRed(node.isRed());
        node.setRed(true);
        return x;
    }

    private ColorNode<Key, Value> rotateRight(ColorNode node) {
        ColorNode x = node.left;
        node.left = x.right;
        x.right = node;
        x.setRed(node.isRed());
        node.setRed(true);
        return x;
    }

    private void flipColors(ColorNode node) {
        node.setRed(true);
        node.left.setRed(false);
        node.right.setRed(false);
    }

    // Printo a árvore verticalmente
    public void mostraArvore() {
        mostraArvore(root, 0);
    }

    private void mostraArvore(ColorNode<Key, Value> node, int b) {
        if (node == null) {
            return;
        }

        mostraArvore(node.right, b + 1);

        String key = String.valueOf(node.getKey());

        if(node.isRed()) {
            key += "'";
        }

        imprimeNo(key, b);

        mostraArvore(node.left, b + 1);
    }

    private void imprimeNo(String key, int b) {
        for (int i = 0; i < b; i++)
            System.out.print("   ");

        System.out.println(key);
    }

    public void printInorder() {
        System.out.print("[ ");
        iterator().forEach(k -> System.out.print(k + " "));
        System.out.print("]");
    }

    public Iterable<Key> iterator() {
        Queue queue = new ArrayDeque<Key>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(ColorNode<Key, Value> node, Queue<Key> queue) {
        if (node == null) {
            return;
        }

        inorder(node.left, queue);
        queue.add(node.getKey());
        inorder(node.right, queue);
    }
}
