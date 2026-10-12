/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.practicalapplication;
import java.util.Scanner;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class PracticalApplication {
    int[][] matrix = new int[5][5];
    public void AddEdge(int source, int destination) {
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }
    
    public void Display() {
        System.out.println("\nAdjacency Matrix:");
        System.out.println("  0 1 2 3 4");
        for (int i = 0; i < 5; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 5; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void Degree(int vertex) {
        int count = 0;
        for (int i = 0; i < 5; i++) {
            if (matrix[vertex][i] == 1) {
                count++;
            }
        }
        System.out.println("Degree of Department " + vertex + ": " + count);
    }

    public int CheckEdge(int source, int destination) {
        return matrix[source][destination];
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        PracticalApplication G1 = new PracticalApplication();
        int choice;
        do {
            System.out.println("\n--- Department Communication ---");
            System.out.println("Departments are numbered 0 to 4.");
            System.out.println("1. Add a connection");
            System.out.println("2. Display adjacency matrix");
            System.out.println("3. Check a connection");
            System.out.println("4. Find department degree");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = input.nextInt();
            switch (choice) {
                case 1: {
                    System.out.print("Enter first department: ");
                    int source = input.nextInt();
                    System.out.print("Enter second department: ");
                    int destination = input.nextInt();
                    if (source < 0 || source > 4
                            || destination < 0 || destination > 4) {
                        System.out.println("Enter department numbers from 0 to 4.");
                    } else if (source == destination) {
                        System.out.println("Choose two different departments.");
                    } else {
                        G1.AddEdge(source, destination);
                        System.out.println("Connection added!");
                    }
                    break;
                }

                case 2: {
                    G1.Display();
                    break;
                }

                case 3: {
                    System.out.print("Enter first department: ");
                    int source = input.nextInt();

                    System.out.print("Enter second department: ");
                    int destination = input.nextInt();

                    if (source < 0 || source > 4
                            || destination < 0 || destination > 4) {
                        System.out.println("Enter department numbers from 0 to 4.");
                    } else if (G1.CheckEdge(source, destination) == 1) {
                        System.out.println("Departments are directly connected.");
                    } else {
                        System.out.println("Departments are not directly connected.");
                    }
                    break;
                }

                case 4: {
                    System.out.print("Enter department number: ");
                    int vertex = input.nextInt();
                    if (vertex < 0 || vertex > 4) {
                        System.out.println("Enter a department number from 0 to 4.");
                    } else {
                        G1.Degree(vertex);
                    }
                    break;
                }

                case 5: {
                    System.out.println("Program ended.");
                    break;
                }
                default: {
                    System.out.println("Invalid choice!");
                }
            }
        } while (choice != 5);
    }
}