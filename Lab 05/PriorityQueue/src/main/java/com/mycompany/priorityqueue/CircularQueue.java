/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.priorityqueue;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class CircularQueue {  
        int [] circularQueue = new int [5]; 
        int front = 0;
        int rear = -1;
        int count = 0;
        
        public boolean isEmpty(){
            return count == 0;
        }
        
       public boolean isFull(){
           return count ==5;
       }
       public void enqueue(int n){
           if(isFull()){
               System.out.println("Queue Overflow!");
               return;
           }
           rear = (rear +1) % 5;
           circularQueue[rear] = n;
           count++;
           System.out.println(n + " is added to the Queue!");
       }
       public void dequeue(){
           if(isEmpty()){
               System.out.println("Queue Underflow!");
               return;
           }
           System.out.println(circularQueue[front] + " removed!");
           front = (front+1) % 5;
           count--;
       }
       public void peek(){
           if(isEmpty()){
               System.out.println("Queue is Empty!");
               return;
           } else {
               System.out.println("front: " + circularQueue[front]);
           }
           
       }
       public void display(){
           if(isEmpty()){
               System.out.println("Queue is Empty!");
               return;
           }
           for(int i=0; i< count;i++){
               int index = (front + i) % 5;
               System.out.println(circularQueue[index] + " ");
           }
           System.out.println(" ");
       }
       
    public static void main(String[] args) {
        CircularQueue c1 = new CircularQueue();
        c1.enqueue (10);
        c1.enqueue (20);
        c1.enqueue (30);
        c1.enqueue (40);
        c1.dequeue();
        c1.dequeue();
        c1.enqueue (50);
        c1.enqueue (60);
        c1.display();
    }
}
