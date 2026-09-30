/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.menudrivenprogram;
import java.util.Scanner;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class MenuDrivenProgram {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        CircularQueue cq = new CircularQueue();
        PriorityQueue pq = new PriorityQueue();
        DeQueue dq = new DeQueue();
        InfixToPostfix ip = new InfixToPostfix();

        int choice;
        do {
            System.out.println("\n========== DATA STRUCTURES LAB 5 ==========");
            System.out.println("1. Circular Queue");
            System.out.println("2. Priority Queue");
            System.out.println("3. Deque");
            System.out.println("4. Infix to Postfix");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            if (choice == 1) {
                System.out.println("\n--- Circular Queue ---");
                cq.enqueue(10);
                cq.enqueue(20);
                cq.enqueue(30);
                cq.enqueue(40);

                cq.dequeue();
                cq.dequeue();

                cq.enqueue(50);
                cq.enqueue(60);

                cq.display();
            } else if (choice == 2) {
                System.out.println("\n--- Priority Queue ---");
                pq.insert(10, 3);
                pq.insert(20, 1);
                pq.insert(30, 2);
                pq.insert(40, 1);
                
                pq.display();

                pq.remove();

                System.out.println("After Removal:");
                pq.display();
            } else if (choice == 3) {
                System.out.println("\n--- Deque ---");
                dq.insertRear(20);
                dq.insertRear(30);

                dq.insertFront(10);

                dq.display();

                dq.deleteFront();
                dq.deleteRear();

                dq.display();
            } else if (choice == 4) {
                sc.nextLine();
                System.out.println("\n--- Infix to Postfix ---");

                System.out.print("Enter Infix Expression: ");
                String expression = sc.nextLine();

                System.out.println("Infix Expression:");
                System.out.println(expression);

                System.out.println("Postfix Expression:");
                System.out.println(ip.Infix_To_Postfix(expression));
            } else if (choice == 5) {
                System.out.println("Program Ended!");
            } else {
                System.out.println("Invalid Choice!");
            }
        } while (choice != 5);
    }
}