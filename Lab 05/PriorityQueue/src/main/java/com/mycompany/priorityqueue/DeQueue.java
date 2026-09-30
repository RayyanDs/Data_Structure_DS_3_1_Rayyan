/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.priorityqueue;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class DeQueue {
    int [] arr = new int[5];
    int size = 0;
   
    void insertRear(int value){
        if(size == 5){
            System.out.println("Queue Overflow!");
            return;
        }
        arr[size] = value;
        size++;
        System.out.println(value + " value added!");
    }
    
    void insertFront(int value){
        if(size == 5){
            System.out.println("Queue Overflow!");
            return;
        }
        for(int i=size; i>0; i--){ //can be solved like this [front = (front -1 + capacity) % capacity]
            arr[i] = arr[i-1];
        }
        arr[0] = value;
        size++;
        System.out.println(value + " inserted at front");
    }
    void deleteFront(){
        if(size == 0){
            System.out.println("Queue Empty!");
            return;
        }
        System.out.println(arr[0] + " value deleted");
        for(int i =0; i < size-1; i++){
            arr[i] = arr[i+1];
        }
        size--;
    }
    void deleteRear(){
        if(size == 0){
            System.out.println("Queue Empty!");
            return;
        }
        System.out.println(arr[size-1] + " deleted");
        size--;
    }
    void display(){
        System.out.println("DeQueue: ");
        for (int i = 0; i < size; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
    public static void main(String [] args){
        DeQueue d = new DeQueue();

        d.insertRear(20);
        d.insertRear(30);

        d.insertFront(10);

        d.display();

        d.deleteFront();
        d.deleteRear();

        d.display();
    }
}
