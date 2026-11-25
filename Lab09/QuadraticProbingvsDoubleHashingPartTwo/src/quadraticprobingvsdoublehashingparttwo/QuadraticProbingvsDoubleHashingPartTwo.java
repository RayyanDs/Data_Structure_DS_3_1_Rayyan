/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quadraticprobingvsdoublehashingparttwo;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class QuadraticProbingvsDoubleHashingPartTwo {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int size = 11;
        int[] table = new int[size];
        for (int i = 0; i < size; i++) {
            table[i] = -1;
        }
        int[] keys = {22, 33, 44, 11, 55};
        for (int key : keys) {
            int h1 = key % 11;
            int h2 = 7 - (key % 7);
            int i = 0;
            while (i < size) {
                int index = (h1 + i * h2) % size;
                if (table[index] == -1) {
                    table[index] = key;
                    break;
                }
                i++;
            }
        }
        System.out.println("Double Hashing:");
        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + table[i]);
        }
    }
    
}
