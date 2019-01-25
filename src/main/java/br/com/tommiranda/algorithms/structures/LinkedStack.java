package br.com.tommiranda.algorithms.structures;

public class LinkedStack<T> {

    private Node<T> first;

    private class Node<T> {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(T item) {
        Node<T> oldFirst = first;
        first = new Node<T>();
        first.item = item;
        first.next = oldFirst;
    }

    public T pop() {
        T item = first.item;
        first = first.next;
        return item;
    }

    public void print() {
        if(first == null) {
            System.out.printf("[ ]");
        }

        System.out.print("[ ");
        Node aux = first;
        while(aux != null) {
            System.out.printf(aux.item + " ");
            aux = aux.next;
        }
        System.out.println("]");
    }
}
