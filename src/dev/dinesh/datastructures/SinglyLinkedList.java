package dev.dinesh.datastructures;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class SinglyLinkedList<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null, tail = null;

    public SinglyLinkedList(){}

    @Override
    public Iterator<T> iterator() {
        return null;
    }

    @Override
    public void forEach(Consumer<? super T> consumer) {

    }

    @Override
    public Spliterator<T> spliterator() {
        return null;
    }

    private static class Node<T> {
        private T data;
        private Node<T> next;

        public Node (T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        @Override
        public String toString() {
            return data == null ? "null" : data.toString();
        }

    }

    public void add(T data) {
        addLast(data);
    }

    public void addLast(T data) {
        if(size == 0) {
            head = tail = new Node<>(data, null);
        } else {
            Node<T> newNode = new Node<>(data, null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addFirst(T data) {
        if(size == 0) {
            head = tail = new Node<>(data, null);
        } else {
            head = new Node<>(data, head);
        }
        size++;
    }

    public void addAt(T data, int index) {

    }

}