package dev.dinesh.stub;

import dev.dinesh.datastructures.DynamicArray;
import dev.dinesh.datastructures.Stack;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

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

//        String a = "cipher  \u0000 \u0000\u0000";
//
//        a = a.replaceAll("\\s+$", "");
//        System.out.println(a);
//
//        Stack stack = new Stack(90);
//
//        System.out.println(stack.isEmpty());
//        stack.push(10);
//
//        stack.push(20);
//        System.out.println(stack.peek());
//
//        stack.push(30);
//        System.out.println(stack.peek());
//
//        System.out.println(stack.size());
//        System.out.println(stack.isEmpty());
//
//        stack.pop();
//
//        System.out.println(stack.peek());
//        System.out.println(stack.toString());
//
//        stack.pop();
//        System.out.println(stack.toString());
//
//        stack.push(1000);
//        System.out.println(stack.toString());
//
//        stack.pop();
//
//        System.out.println(stack.toString());

        System.out.println("Hello Donnie!!!");

        List enabledQueues = new ArrayList();

        try {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(new FileReader("E:\\license.json"));
            JSONObject jsonObject = (JSONObject) obj;
            enabledQueues =  (ArrayList) ((JSONObject) obj).get("DCEE");
        } catch (Exception e) {

        }

        System.out.println(enabledQueues);

        System.out.println("Bye Donnie!!!");

    }

}