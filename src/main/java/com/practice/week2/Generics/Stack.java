package com.practice.week2.Generics;

import java.util.EmptyStackException;

public class Stack<T> {
    private T[] elements;
    private int top;
    private int size;

    public Stack(int size) {
        this.size = size;
        this.top =-1;
        this.elements = (T[]) new Object[size];
    }

    void push(T x)
    {
        if(top+1 == size)
        {
            System.out.println("Stack Overflow");
            //throw new StackOverflowError();
        }
        else
            elements[++top]=x;
    }
    public T pop()
    {
        if(isEmpty())
        {
            System.out.println("Stack Underflow");
            //throw new EmptyStackException();
            return null;
        }
        else
            return elements[top--];
    }
    public T peek()
    {
        if(isEmpty())
        {
            System.out.println("Empty Stack");
            //throw new EmptyStackException();
            return null;
        }
        else
            return elements[top];
    }
    public boolean isEmpty()
    {
        return top == -1;
    }
    public String toString()
    {

        String Ans = "";

        for (int i = 0; i < top; i++) {
            Ans += String.valueOf(elements[i]) + "->";
        }

        Ans += String.valueOf(elements[top]);

        return Ans;
    }

    public static void main(String[] args)
    {
        Stack<Integer> s1 = new Stack<>(3);

        s1.push(10);
        s1.push(20);
        s1.push(30);
        System.out.println("s1 after pushing 10, 20 and 30 :\n" + s1);

        s1.pop();
        System.out.println("s1 after pop :\n" + s1);
        System.out.println("s1 after multiple pop :");
        s1.pop();
        s1.pop();
        s1.pop();

        Stack<String> s2 = new Stack<>(3);

        s2.push("hello");
        s2.push("world");
        s2.push("java");
        System.out.println("\ns2 after pushing 3 elements :\n" + s2);

        System.out.println("s2 after pushing 4th element :");
        s2.push("GFG");

        Stack<Float> s3 = new Stack<>(2);
        s3.push(100.0f);
        s3.push(200.0f);

        System.out.println(
                "\ns3 after pushing 2 elements :\n" + s3);

        System.out.println("top element of s3:\n"
                + s3.peek());
    }
}
