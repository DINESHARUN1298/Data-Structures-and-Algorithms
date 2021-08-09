package dev.dinesh;

public class Test {

    public void implementDynamicArray() {

        DynamicArray dynamicArray = new DynamicArray(2);

        System.out.println(dynamicArray.isEmpty());

        dynamicArray.add(1);
        dynamicArray.add(2);
        System.out.println(dynamicArray.getSize());
        dynamicArray.add(3);
        System.out.println(dynamicArray.getSize());
        dynamicArray.add(3);

        System.out.println(dynamicArray.toString());
        System.out.println(dynamicArray.getSize());
        System.out.println(dynamicArray.isEmpty());
        System.out.println(dynamicArray.get(1));
        dynamicArray.set(3,4);
        System.out.println(dynamicArray.isEmpty());
        System.out.println(dynamicArray.toString());
        dynamicArray.remove(5);
        System.out.println(dynamicArray.toString());

    }

    public static void main(String[] args) {

        Stack stack = new Stack(90);

        System.out.println(stack.isEmpty());
        stack.push(10);

        stack.push(20);
        System.out.println(stack.peek());

        stack.push(30);
        System.out.println(stack.peek());

        System.out.println(stack.size());
        System.out.println(stack.isEmpty());

        stack.pop();

        System.out.println(stack.peek());
        System.out.println(stack.toString());

        stack.pop();
        System.out.println(stack.toString());

        stack.push(1000);
        System.out.println(stack.toString());

        stack.pop();

        System.out.println(stack.toString());

    }

}