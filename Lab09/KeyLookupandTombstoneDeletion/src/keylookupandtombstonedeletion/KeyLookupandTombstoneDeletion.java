/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package keylookupandtombstonedeletion;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
/**
 * @param args the command line arguments
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

public class KeyLookupandTombstoneDeletion {

    static HashEntry[] table = new HashEntry[7];

    static int h1(int key) {
        return key % 7;
    }

    static int h2(int key) {
        return 5 - (key % 5);
    }

    static void insert(int key, String value) {

        for (int i = 0; i < 7; i++) {

            int index = (h1(key) + i * h2(key)) % 7;

            if (table[index] == null || table[index].isDeleted) {

                table[index] = new HashEntry(key, value);
                return;
            }
        }

        System.out.println("Table is full!");
    }

    static void delete(int key) {

        for (int i = 0; i < 7; i++) {

            int index = (h1(key) + i * h2(key)) % 7;

            if (table[index] == null) {
                System.out.println("Key not found!");
                return;
            }

            if (!table[index].isDeleted
                    && table[index].key == key) {

                table[index].isDeleted = true;
                System.out.println("Key " + key + " deleted.");
                return;
            }
        }

        System.out.println("Key not found!");
    }

    static void search(int key) {

        for (int i = 0; i < 7; i++) {

            int index = (h1(key) + i * h2(key)) % 7;

            if (table[index] == null) {
                System.out.println("Key not found!");
                return;
            }

            if (!table[index].isDeleted
                    && table[index].key == key) {

                System.out.println("Found: " + table[index].value);
                return;
            }
        }

        System.out.println("Key not found!");
    }

    static void display() {

        System.out.println("\nHash Table:");

        for (int i = 0; i < 7; i++) {

            if (table[i] == null) {
                System.out.println("Index " + i + ": EMPTY");
            } else if (table[i].isDeleted) {
                System.out.println("Index " + i + ": DELETED");
            } else {
                System.out.println("Index " + i + ": "
                        + table[i].key + " - " + table[i].value);
            }
        }
    }

    public static void main(String[] args) {
        insert(12, "Ali");
        insert(19, "Sara");
        insert(26, "Bilal");
        insert(5, "Hina");

        System.out.println("Before Deletion:");
        display();

        delete(19);

        System.out.println("\nAfter Deletion:");
        display();

        System.out.println("\nSearching for key 26:");
        search(26);
    }

}
