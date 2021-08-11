package dev.dinesh;

import java.util.Iterator;

public class Queue<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null, tail = null;

    public Queue() {}

    public Queue(T firstElement) {
        enQueue(firstElement);
    }

    public void enQueue(T element) {
        addLast(element);
    }

    public T deQueue() {
        return removeFirst();
    }

    public T peek() {
        if(isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }
        return head.data;
    }

    public void addLast(T element) {
        if(head == null) {
            head = tail = new Node<>(element,null, null);
        } else {
            Node<T> newNode = new Node<>(element, null, tail);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T removeFirst() {

        T element;

        if(isEmpty()) {
            throw new RuntimeException("Queue is empty!");
        }

        Node firstNode = head;
        element = (T) firstNode.data;

        if(head == tail) {
            tail.data = null;
            tail.next = tail.prev = null;
            head = tail = null;
        } else {
            head = firstNode.next;
            head.prev = null;
        }

        size--;
        return element;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {

        private T data;
        private Node<T> next, prev;

        public Node(T data, Node<T> next, Node<T> prev) {
            this.data = data;
            this.next = next;
            this.prev = prev;
        }

        @Override
        public String toString() {
            return data == null ? "null" : data.toString();
        }

    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            Node<T> traverse = head;

            @Override
            public boolean hasNext() {
                return traverse != null;
            }

            @Override
            public T next() {
                T data = traverse.data;
                traverse = traverse.next;
                return data;
            }
        };
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        Iterator iterator = this.iterator();

        while (iterator.hasNext()) {

            stringBuilder.append(iterator.next());

            if(iterator.hasNext()) {
                stringBuilder.append( " -> ");
            }

        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}