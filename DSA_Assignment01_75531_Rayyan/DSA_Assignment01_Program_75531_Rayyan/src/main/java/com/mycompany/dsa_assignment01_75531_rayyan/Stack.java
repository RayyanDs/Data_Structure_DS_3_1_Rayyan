package com.mycompany.dsa_assignment01_75531_rayyan;

class Stack {
    String[] arr = new String[10];
    int top = -1;
    public void push(String value) {
        if (top == 9) {
            System.out.println("Stack Overflow!");
        } else {
            top++;
            arr[top] = value;
            System.out.println("Transaction Added!");
        }
    }

    public void pop() {
        if (top == -1) {
            System.out.println("Stack Underflow!");
        } else {
            System.out.println("Removed: " + arr[top]);
            top--;
        }
    }

    public void peek() {
        if (top == -1) {
            System.out.println("Stack Empty!");
        } else {
            System.out.println("Latest Transaction: " + arr[top]);
        }
    }

    public void display() {
        if (top == -1) {
            System.out.println("Stack Empty!");
        } else {
            for (int i = top; i >= 0; i--) {
                System.out.println(arr[i]);
            }
        }
    }
}
