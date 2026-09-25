/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.queuearray;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class QueueArray {
    int[] queue = new int[5];
    int front = 0;
    int rear = -1;
    void enqueue(int value) {
        if (rear == 4) {
            System.out.println("Queue Overflow! Queue is full.");
        } else {
            rear++;
            queue[rear] = value;
            System.out.println(value + " enqueued into queue.");
        }
    }
    void dequeue() {
        if (front > rear) {
            System.out.println("Queue Underflow! Queue is empty.");
        } else {
            System.out.println(queue[front] + " dequeued from queue.");
            front++;
        }
    }

    void peek() {
        if (front > rear) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Front element: " + queue[front]);
        }
    }

    void display() {
        if (front > rear) {
            System.out.println("Queue is empty.");
        } else {
            System.out.println("Queue elements:");

            for (int i = front; i <= rear; i++) {
                System.out.println(queue[i]);
            }
        }
    }

    public static void main(String[] args) {

        QueueArray q = new QueueArray();

        q.enqueue(10);
        q.enqueue(20);
        q.enqueue(30);

        q.display();

        q.peek();

        q.dequeue();

        q.display();
    }
}
