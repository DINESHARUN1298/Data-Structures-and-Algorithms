package dev.dinesh.stub;

import java.util.concurrent.atomic.AtomicInteger;

public class Test {

    static AtomicInteger a;

    public static AtomicInteger m1()
    {
        try
        {
            a = new AtomicInteger(1);
            return a;
        }
        finally
        {
            a = new AtomicInteger(2);
        }
    }

    public static void main(String[] args) {
        System.out.println(m1());
        System.out.println(a);
    }

}