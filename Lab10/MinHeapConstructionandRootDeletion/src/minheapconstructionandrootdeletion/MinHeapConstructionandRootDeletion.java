
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package minheapconstructionandrootdeletion;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class MinHeapConstructionandRootDeletion {

    static int[] heap = new int[10];
    static int size = 0;

    static int parent(int i) {
        return (i - 1) / 2;
    }

    static void swap(int i, int j) {
        int temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert into Min Heap
    static void insert(int value) {

        if (size == 10) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while (current > 0 &&
                heap[current] < heap[parent(current)]) {

            swap(current, parent(current));
            current = parent(current);
        }
    }

    // View minimum
    static int peek() {
        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        return heap[0];
    }

    // Restore Min Heap after deletion
    static void heapifyDown(int i) {

        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] < heap[smallest]) {
            smallest = left;
        }

        if (right < size && heap[right] < heap[smallest]) {
            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    // Remove minimum
    static int extractMin() {

        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int min = heap[0];

        heap[0] = heap[size - 1];
        size--;

        if (size > 0) {
            heapifyDown(0);
        }

        return min;
    }

    // Display heap
    static void display() {

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] values = {40, 15, 30, 10, 50, 20, 25};

        for (int value : values) {
            insert(value);
        }

        System.out.print("Min Heap: ");
        display();

        System.out.println("Minimum Element: " + peek());

        System.out.println("First Extracted: " + extractMin());

        System.out.print("Heap After First Deletion: ");
        display();

        System.out.println("Second Extracted: " + extractMin());

        System.out.print("Heap After Second Deletion: ");
        display();

        System.out.println("Remaining Elements: " + size);
    }
}
