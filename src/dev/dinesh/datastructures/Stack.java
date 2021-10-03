package dev.dinesh.datastructures;

import java.util.Iterator;

public class Stack<T> implements Iterable<T> {

    private int size = 0;
    private Node<T> head = null;

    public Stack(){}

    public Stack(T value) {
        push(value);
    }

    public void push(T value) {
        head = new Node<>(value, head);
        size++;
    }

    public T pop() {

        if(isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }

        T value = head.value;
        head = head.next;
        size--;
        return value;
    }

    public T peek() {

        if(isEmpty()) {
            throw new RuntimeException("Stack is Empty!");
        }

        return head.value;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public int size() {
        return size;
    }

    private static class Node<T> {

        private T value ;
        private Node<T> next;

        public Node(T value, Node<T> next) {
            this.value = value;
            this.next = next;
        }

    }

    @Override
    public  Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> iterate = head;

            @Override
            public boolean hasNext() {
                return iterate != null;
            }

            @Override
            public T next() {
                T value = iterate.value;
                iterate = iterate.next;
                return  value;
            }
        };
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        Iterator<T> iterator = this.iterator();

        while(iterator.hasNext()) {

            stringBuilder.append(iterator.next());

            if(iterator.hasNext()) {
                stringBuilder.append(" -> ");
            }

        }

        stringBuilder.append("]");
        return stringBuilder.toString();
    }

}