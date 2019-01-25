package br.com.tommiranda.algorithms.structures;

public class LinkedQueue<T> {

    private Node<T> first, last;

    private class Node<T> {
        T item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(T item) {
        Node oldLast = last;
        last = new Node<T>();
        last.item = item;

        if(isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public T dequeue() {
        T item = first.item;
        first = first.next;

        if(isEmpty())
            last = null;

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
