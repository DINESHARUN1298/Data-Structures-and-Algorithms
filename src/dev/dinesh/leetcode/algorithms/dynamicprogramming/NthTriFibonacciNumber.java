package dev.dinesh.leetcode.algorithms.dynamicprogramming;

public class NthTriFibonacciNumber {
    public int tribonacci(int n) {
        int[] fib = new int[n+1];
        if(n <= 1) {
            return n;
        }
        fib[0] = 0;
        fib[1] = 1;
        fib[2] = 1;
        for(int index = 3; index <= n; index++) {
            fib[index] = fib[index-1] + fib[index-2] + fib[index-3];
        }
        return fib[n];
    }
}