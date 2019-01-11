package br.com.tommiranda.algorithms;

public class LinkedStack {

    private Node first;

    private class Node {
        String item;
        Node next;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void push(String item) {
        Node oldFirst = first;
        first = new Node();
        first.item = item;
        first.next = oldFirst;
    }

    public String pop() {
        String item = first.item;
        first = first.next;
        return item;
    }

    public void print() {
        if(first == null) {
            System.out.printf("[ ]");
        }

        System.out.print("[ ");
        Node aux = first;
        while(aux.next != null) {
            System.out.printf(aux.item + " ");
            aux = aux.next;
        }
        System.out.print("]");
    }
}
