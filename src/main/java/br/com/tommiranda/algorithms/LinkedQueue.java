package br.com.tommiranda.algorithms;

public class LinkedQueue {

    private Node first, last;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void enqueue(String item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;

        if(isEmpty())
            first = last;
        else
            oldLast.next = last;
    }

    public String dequeue() {
        String item = first.item;
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
