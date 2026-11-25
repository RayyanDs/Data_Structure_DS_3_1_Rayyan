/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package simplehospitalemergencyqueueusingminheap;
class Patient {

    String name;
    int priority;

    Patient(String name, int priority) {
        this.name = name;
        this.priority = priority;
    }
}

class PatientMinHeap {

    Patient[] heap;
    int size;
    int capacity;

    PatientMinHeap(int capacity) {
        this.capacity = capacity;
        heap = new Patient[capacity];
        size = 0;
    }

    // Parent index
    int parent(int i) {
        return (i - 1) / 2;
    }

    // Swap patients
    void swap(int i, int j) {
        Patient temp = heap[i];
        heap[i] = heap[j];
        heap[j] = temp;
    }

    // Insert patient
    void insert(Patient patient) {

        if (size == capacity) {
            System.out.println("Queue is full!");
            return;
        }

        heap[size] = patient;
        int current = size;
        size++;

        while (current > 0 &&
                heap[current].priority <
                heap[parent(current)].priority) {

            swap(current, parent(current));
            current = parent(current);
        }
    }

    // View next patient
    Patient peek() {

        if (size == 0) {
            return null;
        }

        return heap[0];
    }

    // Restore Min Heap
    void heapifyDown(int i) {

        int smallest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < size &&
                heap[left].priority < heap[smallest].priority) {

            smallest = left;
        }

        if (right < size &&
                heap[right].priority < heap[smallest].priority) {

            smallest = right;
        }

        if (smallest != i) {
            swap(i, smallest);
            heapifyDown(smallest);
        }
    }

    // Treat patient
    Patient extractMin() {

        if (size == 0) {
            return null;
        }

        Patient min = heap[0];

        heap[0] = heap[size - 1];
        size--;

        if (size > 0) {
            heapifyDown(0);
        }

        return min;
    }

    // Display waiting patients
    void display() {

        if (size == 0) {
            System.out.println("No patients waiting.");
            return;
        }

        for (int i = 0; i < size; i++) {

            System.out.println(
                    heap[i].name + " - Priority: "
                    + heap[i].priority);
        }
    }
}

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class SimpleHospitalEmergencyQueueUsingMinHeap {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        PatientMinHeap queue = new PatientMinHeap(10);

        // Insert patients
        queue.insert(new Patient("Ali", 3));
        queue.insert(new Patient("Sara", 1));
        queue.insert(new Patient("Bilal", 4));
        queue.insert(new Patient("Ayesha", 2));
        queue.insert(new Patient("Usman", 5));

        // Display next patient
        Patient next = queue.peek();

        System.out.println("Next Patient:");

        System.out.println(next.name +
                " - Priority: " + next.priority);

        // Treat first patient
        System.out.println("\nTreating Patients:");

        Patient first = queue.extractMin();

        System.out.println(first.name +
                " - Priority: " + first.priority);

        // Treat second patient
        Patient second = queue.extractMin();

        System.out.println(second.name +
                " - Priority: " + second.priority);

        // Display remaining patients
        System.out.println("\nRemaining Patients:");

        queue.display();
    }
    
}
