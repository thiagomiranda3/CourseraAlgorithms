package br.com.tommiranda.algorithms.trees;

public class SimpleBinarySearchTree<Key extends Comparable<Key>, Value> {

    private Node<Key, Value> root;

    public void put(Key key, Value value) {
        put(root, key, value);
    }

    private Node<Key, Value> put(Node<Key, Value> node, Key key, Value value) {
        if(node == null) {
            return new Node<>(key, value);
        }

        int cmp = key.compareTo(node.getKey());

        if(cmp < 0) {
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

        while(x != null) {
            int cmp = key.compareTo(x.getKey());

            if(cmp < 0) {
                x = x.left;
            } else if(cmp > 0) {
                x = x.right;
            } else {
                return x.getValue();
            }
        }

        return null;
    }

    public void delete(Key key) {

    }

    public Iterable<Key> iterator() {
        return null;
    }
}
