/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package maxheapconstructionandfindingtopscores;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class MaxHeapConstructionandFindingTopScores {
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

    // Insert into Max Heap
    static void insert(int value) {

        if (size == 10) {
            System.out.println("Heap is full!");
            return;
        }

        heap[size] = value;
        int current = size;
        size++;

        while (current > 0 &&
                heap[current] > heap[parent(current)]) {

            swap(current, parent(current));
            current = parent(current);
        }
    }

    // View maximum
    static int peek() {

        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        return heap[0];
    }

    // Restore Max Heap
    static void heapifyDown(int i) {

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size && heap[left] > heap[largest]) {
            largest = left;
        }

        if (right < size && heap[right] > heap[largest]) {
            largest = right;
        }

        if (largest != i) {
            swap(i, largest);
            heapifyDown(largest);
        }
    }

    // Remove maximum
    static int extractMax() {

        if (size == 0) {
            System.out.println("Heap is empty!");
            return -1;
        }

        int max = heap[0];

        heap[0] = heap[size - 1];
        size--;

        if (size > 0) {
            heapifyDown(0);
        }

        return max;
    }

    // Display heap
    static void display() {

        for (int i = 0; i < size; i++) {
            System.out.print(heap[i] + " ");
        }

        System.out.println();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[] scores = {65, 92, 78, 85, 99, 70, 88};

        for (int score : scores) {
            insert(score);
        }

        System.out.print("Max Heap: ");
        display();

        System.out.println("Highest Score: " + peek());

        System.out.println("1st Highest: " + extractMax());
        System.out.println("2nd Highest: " + extractMax());
        System.out.println("3rd Highest: " + extractMax());

        System.out.print("Remaining Scores: ");
        display();
    }
    
}
