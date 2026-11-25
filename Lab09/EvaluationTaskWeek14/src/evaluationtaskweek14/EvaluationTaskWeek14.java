
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package evaluationtaskweek14;

/**
 *
 * @author MUHAMMAD RAYYAN
 */

class HashEntry {

    int key;
    String value;
    boolean isDeleted;

    HashEntry(int key, String value) {
        this.key = key;
        this.value = value;
        this.isDeleted = false;
    }
}

class ProbingHashTable {

    private HashEntry[] table;
    private int size;
    private int count;

    public ProbingHashTable(int size) {
        this.size = size;
        table = new HashEntry[size];
        count = 0;
    }

    private int h1(int key) {
        return Math.floorMod(key, size);
    }

    private int h2(int key) {
        return 5 - Math.floorMod(key, 5);
    }

    private int probeIndex(int key, int i, String mode) {

        int base = h1(key);

        if (mode.equalsIgnoreCase("LINEAR")) {
            return (base + i) % size;
        }
        else if (mode.equalsIgnoreCase("QUADRATIC")) {
            return (base + i * i) % size;
        }
        else if (mode.equalsIgnoreCase("DOUBLE")) {
            return (base + i * h2(key)) % size;
        }

        throw new IllegalArgumentException("Invalid probing method");
    }

    public boolean insert(int key, String value, String mode) {

        int firstDeleted = -1;

        for (int i = 0; i < size; i++) {

            int index = probeIndex(key, i, mode);

            if (table[index] == null) {

                int pos = (firstDeleted != -1) ? firstDeleted : index;

                table[pos] = new HashEntry(key, value);
                count++;

                return true;
            }
            else if (table[index].isDeleted) {

                if (firstDeleted == -1) {
                    firstDeleted = index;
                }
            }
            else if (table[index].key == key) {

                table[index].value = value;
                return true;
            }
        }

        if (firstDeleted != -1) {

            table[firstDeleted] = new HashEntry(key, value);
            count++;

            return true;
        }

        System.out.println("Hash Table is full!");
        return false;
    }

    public String search(int key, String mode) {

        for (int i = 0; i < size; i++) {

            int index = probeIndex(key, i, mode);

            if (table[index] == null) {
                return null;
            }

            if (!table[index].isDeleted &&
                    table[index].key == key) {

                return table[index].value;
            }
        }

        return null;
    }

    public boolean delete(int key, String mode) {

        for (int i = 0; i < size; i++) {

            int index = probeIndex(key, i, mode);

            if (table[index] == null) {
                return false;
            }

            if (!table[index].isDeleted &&
                    table[index].key == key) {

                table[index].isDeleted = true;
                count--;

                return true;
            }
        }

        return false;
    }

    public void display() {

        System.out.println("\nHash Table:");

        for (int i = 0; i < size; i++) {

            if (table[i] == null) {
                System.out.println("Index " + i + ": EMPTY");
            }
            else if (table[i].isDeleted) {
                System.out.println("Index " + i + ": DELETED");
            }
            else {
                System.out.println("Index " + i + ": ("
                        + table[i].key + ", "
                        + table[i].value + ")");
            }
        }

        System.out.println("Total Elements: " + count);
    }
}

public class EvaluationTaskWeek14 {

    public static void runTest(String mode) {

        System.out.println("\n==========================");
        System.out.println(mode + " PROBING");
        System.out.println("==========================");

        ProbingHashTable ht = new ProbingHashTable(11);

        // Insert values
        ht.insert(22, "Ali", mode);
        ht.insert(33, "Sara", mode);
        ht.insert(44, "Bilal", mode);
        ht.insert(11, "Hina", mode);
        ht.insert(55, "Ahmed", mode);

        // Display table
        ht.display();

        // Search operation
        System.out.println("\nSearching for 33:");

        String result = ht.search(33, mode);

        if (result != null) {
            System.out.println("Found: " + result);
        }
        else {
            System.out.println("Key not found!");
        }

        // Delete operation
        System.out.println("\nDeleting key 44:");

        if (ht.delete(44, mode)) {
            System.out.println("Key deleted successfully!");
        }
        else {
            System.out.println("Key not found!");
        }

        // Display after deletion
        ht.display();

        // Search after deletion
        System.out.println("\nSearching for 33 after deletion:");

        System.out.println("Result: " + ht.search(33, mode));
    }

    public static void main(String[] args) {

        runTest("LINEAR");

        runTest("QUADRATIC");

        runTest("DOUBLE");
    }
}
