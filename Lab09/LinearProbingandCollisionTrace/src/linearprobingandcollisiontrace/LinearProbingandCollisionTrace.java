/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linearprobingandcollisiontrace;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class LinearProbingandCollisionTrace {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        int size = 7;
        int[] table = new int[size];

        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }

        int[] keys = {14, 21, 8, 15, 22};
        int collisions = 0;

        for (int key : keys) {

            int index = key % size;

            while (table[index] != -1) {

                collisions++;
                index = (index + 1) % size;
            }

            table[index] = key;
        }

        System.out.println("Hash Table:");

        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + table[i]);
        }

        System.out.println("Total Collisions: " + collisions);

        // Search for 15
        int searchKey = 15;
        boolean found = false;

        for (int i = 0; i < size; i++) {

            int index = (searchKey % size + i) % size;

            if (table[index] == searchKey) {
                found = true;
                break;
            }

            if (table[index] == -1) {
                break;
            }
        }

        System.out.println("Search 15: "
                + (found ? "Found" : "Not Found"));

        // Search for 99
        searchKey = 99;
        found = false;

        for (int i = 0; i < size; i++) {

            int index = (searchKey % size + i) % size;

            if (table[index] == searchKey) {
                found = true;
                break;
            }

            if (table[index] == -1) {
                break;
            }
        }

        System.out.println("Search 99: " + (found ? "Found" : "Not Found"));
    }

}
