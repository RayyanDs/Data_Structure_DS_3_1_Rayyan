/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package quadraticprobingvsdoublehashing;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class QuadraticProbingvsDoubleHashing {

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

            int base = key % size;
            int i = 0;

            while (i < size) {

                int index = (base + i * i) % size;

                if (table[index] == -1) {
                    table[index] = key;
                    break;
                }

                i++;
            }
        }

        System.out.println("Quadratic Probing:");

        for (int i = 0; i < size; i++) {
            System.out.println("Index " + i + ": " + table[i]);
        }
    }
    
}
