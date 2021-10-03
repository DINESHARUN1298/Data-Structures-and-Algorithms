package dev.dinesh.datastructures;

import java.util.Arrays;
import java.util.Iterator;

public class DynamicArray<T> implements Iterable<T> {

    private int size = 0, capacity = 0, initialCapacity = 0;
    private T[] arr;

    public DynamicArray() {
        this(16);
    }

    public DynamicArray(int size) {

        if(size < 0) {
            throw new IllegalArgumentException("Invalid Size");
        }

        this.capacity = size;
        this.initialCapacity = size;
        this.arr = (T[]) new Object[size];
    }

    public int getSize() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size <= 0;
    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new IllegalArgumentException("Invalid Index. Index Requested: " + index);
        } else {
            return arr[index];
        }
    }

    public void set(int index, T element) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index");
        } else {
            arr[index] = element;
        }
    }

    public void clear() {
        this.capacity = this.initialCapacity;
        this.size = 0;
        this.arr = (T[]) new Object[this.capacity];
    }

    public void add(T element) {
        if(size+1 > capacity) {
            if(capacity == 0) {
                capacity = 1;
            } else {
                capacity *= 2;
            }
            this.arr = Arrays.copyOf(this.arr, capacity);
        }
        this.arr[size++] = element;
    }

    public boolean remove(T element) {
        int index = indexOf(element);
        if(index == -1) {
            return false;
        }
        return removeAt(index);
    }

    public boolean removeAt(int index) {

        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Invalid Index Removal. Index: " + index);
        }

        T[] newArr = (T[]) new Object[capacity];

        for(int i = 0, j = 0; i < this.size; i++, j++) {
            if(i == index) {
                j--;
            } else {
                newArr[j] = this.arr[i];
            }
        }

        this.arr = newArr;
        this.size--;
        return true;

    }

    public boolean contains(T element) {
        return indexOf(element) >= 0;
    }

    public int indexOf(T element) {
        for(int i = 0; i < this.size; i++) {
            if(this.arr[i] == element) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");

        for(int i = 0; i < this.size; i++) {
            if(i != this.size-1) {
                stringBuilder.append(this.arr[i] + " ,");
            } else {
                stringBuilder.append(this.arr[i]);
            }
        }

        stringBuilder.append("]");
        return  stringBuilder.toString();

    }

    public Iterator<T> iterator() {
        return  new Iterator<T>() {

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < capacity;
            }

            @Override
            public T next() {
                return get(index++);
            }
        };
    }

}