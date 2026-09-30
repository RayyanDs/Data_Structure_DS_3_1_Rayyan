/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.menudrivenprogram;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class PriorityQueue {
    int[] values = new int[5];
    int[] priorities= new int[5];
    int size = 0;
    
    void insert(int value, int priority){
        if (size == 5){
            System.out.println("Queue Overflow!");
            return;
        }
        values[size] = value;
        priorities[size] = priority;
        size++;
        
        System.out.println(value + " inserted");
    }
    
    void remove(){
    if(size == 0) {
        System.out.println("Queue is Empty");
        return;
    }
    int best = 0;
    for(int i = 0; i < size; i++){
        if(priorities[i] < priorities[best]){
            best = i;
        }
    }
    System.out.println(values[best] + " removed!");
    for(int i = best; i < size - 1; i++){
        values[i] = values[i + 1];
        priorities[i] = priorities[i + 1];
    }
    size--;
}
    void display(){
        for(int i =0; i< size; i++){
            System.out.println("Values " + values[i] + " Priority: " + priorities[i]);
        }
    }
}
