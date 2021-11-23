package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class FibonacciNumber {
    public int fib(int n) {
        int[] fib = new int[n+1];
        if(n <= 1) {
            return n;
        }
        fib[0] = 0;
        fib[1] = 1;
        for(int index = 2; index <= n; index++) {
            fib[index] = fib[index-1] + fib[index-2];
        }
        return fib[n];
    }
}