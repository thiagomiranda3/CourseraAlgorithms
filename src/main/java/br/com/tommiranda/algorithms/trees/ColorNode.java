package br.com.tommiranda.algorithms.trees;

import com.sun.jdi.Value;

public class ColorNode<Key extends Comparable<Key>, Value> {

    private boolean isRed = true;
    private Key key;
    private Value value;
    private int count = 1;
    public ColorNode<Key, Value> left;
    public ColorNode<Key, Value> right;

    public ColorNode(Key key, Value value) {
        this.key = key;
        this.value = value;
    }

    public void setRed(boolean red) {
        isRed = red;
    }

    public boolean isRed() {
        return isRed;
    }

    public Key getKey() {
        return key;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
