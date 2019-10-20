package br.com.tommiranda.algorithms.trees;

import java.util.ArrayDeque;
import java.util.Queue;

public class SimpleBinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

    // Adiciona um nó na árvore
    public void put(Key key, Value value) {
        root = put(root, key, value);
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.getKey());

        if (cmp < 0) {
            node.left = put(node.left, key, value);
        } else if (cmp > 0) {
            node.right = put(node.right, key, value);
        } else {
            node.setValue(value);
        }

        node.setCount(1 + size(node.left) + size(node.right));

        return node;
    }

    // Retorna o valor associado à chave armazenada na árvore
    public Value get(Key key) {
        Node<Key, Value> x = root;

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

    // Retorna o menor valor mais próximo da chave escolhida
    public Key floor(Key key) {
        Node<Key, Value> node = floor(root, key);

        if (node == null) {
            return null;
        }

        return node.getKey();
    }

    private Node<Key, Value> floor(Node<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.getKey());

        if (cmp == 0) {
            return node;
        }

        if (cmp < 0) {
            return floor(node.left, key);
        }

        Node<Key, Value> right = floor(node.right, key);

        if (right != null) {
            return right;
        }

        return node;
    }

    // Retorna o menor valor mais próximo da chave escolhida
    public Key ceiling(Key key) {
        Node<Key, Value> node = ceiling(root, key);

        if (node == null) {
            return null;
        }

        return node.getKey();
    }

    // O maior valor mais próximo da key passada
    private Node<Key, Value> ceiling(Node<Key, Value> node, Key key) {
        if (node == null) {
            return null;
        }

        int cmp = key.compareTo(node.getKey());

        if (cmp == 0) {
            return node;
        }

        if (cmp > 0) {
            return ceiling(node.right, key);
        }

        Node<Key, Value> left = ceiling(node.left, key);

        if (left != null) {
            return left;
        }

        return node;
    }

    // Retorna o número de keys menores que o valor passado
    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node<Key, Value> node, Key key) {
        if (node == null) {
            return 0;
        }

        int cmp = key.compareTo(node.getKey());

        if (cmp < 0) {
            return rank(node.left, key);
        } else if (cmp > 0) {
            return 1 + size(node.left) + rank(node.right, key);
        }

        return size(node.left);
    }

    public void delete(Key key) {

    }

    // Printo a árvore verticalmente
    public void mostraArvore() {
        mostraArvore(root, 0);
    }

    private void mostraArvore(Node<Key, Value> node, int b) {
        if (node == null) {
            return;
        }

        mostraArvore(node.right, b + 1);

        imprimeNo(node.getKey(), b);

        mostraArvore(node.left, b + 1);
    }

    private void imprimeNo(Key key, int b) {
        for (int i = 0; i < b; i++)
            System.out.print("   ");

        System.out.println(key);
    }

    // Retorno o tamanho da árvore
    public int size() {
        return size(root);
    }

    private int size(Node node) {
        if (node == null) {
            return 0;
        }

        return node.getCount();
    }

    public void printInorder() {
        System.out.print("[ ");
        iterator().forEach(k -> System.out.print(k + " "));
        System.out.print("]");
    }

    public Iterable<Key> iterator() {
        Queue queue = new ArrayDeque<Runnable>();
        inorder(root, queue);
        return queue;
    }

    private void inorder(Node<Key, Value> node, Queue<Key> queue) {
        if(node == null) {
            return;
        }

        inorder(node.left, queue);
        queue.add(node.getKey());
        inorder(node.right, queue);
    }
}
