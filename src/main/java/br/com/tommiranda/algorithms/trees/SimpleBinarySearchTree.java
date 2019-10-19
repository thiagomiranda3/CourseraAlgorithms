package br.com.tommiranda.algorithms.trees;

public class SimpleBinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

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

        return node;
    }

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

    public void delete(Key key) {

    }

    public void mostraArvore() {
        mostraArvore(root, 0);
    }

    private void mostraArvore(Node<Key, Value> node, int b) {
        if (node == null) {
            //imprimeNo(null, b);
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

    public Iterable<Key> iterator() {
        return null;
    }
}
