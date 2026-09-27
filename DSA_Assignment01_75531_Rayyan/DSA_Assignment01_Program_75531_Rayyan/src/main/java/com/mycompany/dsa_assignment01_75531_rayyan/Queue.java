package com.mycompany.dsa_assignment01_75531_rayyan;

class Queue {
    String[] arr = new String[10];
    int front = -1;
    int rear = -1;
    public void enqueue(String value) {
        if (rear == 9) {
            System.out.println("Queue Overflow!");
        } else {
            if (front == -1) {
                front = 0;
            }
            rear++;
            arr[rear] = value;
            System.out.println("Order Added!");
        }
    }

    public void dequeue() {
        if (front == -1) {
            System.out.println("Queue Underflow!");
        } else {
            System.out.println("Processed: " + arr[front]);
            front++;
            if (front > rear) {
                front = -1;
                rear = -1;
            }
        }
    }

    public void peek() {
        if (front == -1) {
            System.out.println("Queue Empty!");
        } else {
            System.out.println("Next Order: " + arr[front]);
        }
    }

    public void display() {
        if (front == -1) {
            System.out.println("Queue Empty!");
        } else {
            for (int i = front; i <= rear; i++) {
                System.out.println(arr[i]);
            }
        }
    }
}
