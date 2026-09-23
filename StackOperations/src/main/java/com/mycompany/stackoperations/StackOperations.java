/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.stackoperations;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class StackOperations {
    int[] Stack = new int[5];
    int top = -1;
    void push(int value){
        if(top == 4){
            System.out.println("Stack Overflow! Stack is Full");
        }else{
            top++;
            Stack[top] = value;
            System.out.println("Value added: " + value );
        }
    }
    void pop(){
        if(top == -1){
            System.out.println("Stack Underflow! Stack is empty");
        } else{
            System.out.println("Value " + Stack[top] + " is Popped!");
            top--;
        }
    }
    void peek(){
        if (top == -1){
            System.out.println("Stack is empty!");    
        }else{
            System.out.println("Top element: " + Stack[top]);
        }
    }
    void display(){
        if (top == -1){
            System.out.println("Stack is empty!");
        }else {
            System.out.println("Stack elements: ");
            for(int i = top; i >=0;i--){
                System.out.println(Stack[i]);
            }
        }
    }
    public static void main(String[] args) {
        StackOperations s = new StackOperations();
        s.push(10);
        s.push(20);
        s.push(30);

        s.display();

        s.peek();

        s.pop();

        s.display();
    }
}
