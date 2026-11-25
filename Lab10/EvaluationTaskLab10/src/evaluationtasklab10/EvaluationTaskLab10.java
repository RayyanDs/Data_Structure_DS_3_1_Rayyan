/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evaluationtasklab10;

import java.util.Scanner;

class Heap {

    int[] heap;
    int size;
    int capacity;
    boolean isMin;

    Heap(int capacity, boolean isMin) {

        this.capacity = capacity;
        this.isMin = isMin;

        heap = new int[capacity];
        size = 0;
    }

    // Parent index
    int parent(int i) {
        return (i - 1) / 2;
    }

    // Swap elements
    void swap(int i, int j) {

        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Check heap condition
    boolean compare(int a, int b) {

        if (isMin) {
            return a < b;
        }
        else {
            return a > b;
        }
    }

    // Insert element
    void insert(int value) {

        if (size == capacity) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = value;

        int current = size;
        size++;

        // Heapify-Up
        while (current > 0 &&
                compare(heap[current], heap[parent(current)])) {

            swap(current, parent(current));
            current = parent(current);
        }

        System.out.println("Value inserted successfully!");
    }

    // View root
    int peek() {

        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        return heap[0];
    }

    // Heapify-Down
    void heapifyDown(int i) {

        int best = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size &&
                compare(heap[left], heap[best])) {

            best = left;
        }

        if (right < size &&
                compare(heap[right], heap[best])) {

            best = right;
        }

        if (best != i) {

            swap(i, best);
            heapifyDown(best);
        }
    }

    // Extract root
    int extractRoot() {

        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int root = heap[0];

        heap[0] = heap[size - 1];
        size--;

        if (size > 0) {
            heapifyDown(0);
        }

        return root;
    }

    // Display heap
    void display() {

        if (size == 0) {
            System.out.println("Heap is empty!");
            return;
        }

        System.out.print("Heap Elements: ");

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    // Display size
    void displaySize() {
        System.out.println("Current Size: " + size);
    }
}
/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class EvaluationTaskLab10 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Choose Heap Type:");
        System.out.println("1. Min Heap");
        System.out.println("2. Max Heap");

        System.out.print("Enter choice: ");
        int choice = input.nextInt();

        if (choice != 1 && choice != 2) {
            System.out.println("Invalid choice!");
            input.close();
            return;
        }

        boolean isMin = (choice == 1);

        Heap heap = new Heap(10, isMin);

        int option;

        do {

            System.out.println("\n===== HEAP MENU =====");
            System.out.println("1. Insert");
            System.out.println("2. Peek");
            System.out.println("3. Extract Root");
            System.out.println("4. Display Heap");
            System.out.println("5. Display Size");
            System.out.println("0. Exit");

            System.out.print("Enter option: ");
            option = input.nextInt();

            switch (option) {

                case 1:

                    System.out.print("Enter value: ");
                    int value = input.nextInt();

                    heap.insert(value);
                    break;

                case 2:

                    if (heap.size == 0) {
                        System.out.println("Heap is empty!");
                    }
                    else {
                        System.out.println("Root Element: " +
                                heap.peek());
                    }

                    break;

                case 3:

                    if (heap.size == 0) {
                        System.out.println("Heap is empty!");
                    }
                    else {
                        System.out.println("Removed Element: " +
                                heap.extractRoot());
                    }

                    break;

                case 4:

                    heap.display();
                    break;

                case 5:

                    heap.displaySize();
                    break;

                case 0:

                    System.out.println("Program ended.");
                    break;

                default:

                    System.out.println("Invalid option!");
            }

        } while (option != 0);

        input.close();
    }
    
}
