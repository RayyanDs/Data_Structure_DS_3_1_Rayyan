/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.graphoperations;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class GraphOperations {
    int[][] matrix = new int[5][5];
    public void AddEdge(int source, int destination){
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }
    public void RemoveEdge(int source, int destination){
        matrix[source][destination] = 0;
        matrix[destination][source] = 0;
    }
    public void Display(){
        System.out.println("\nAdjacency Matrix: ");
        System.out.println("  0 1 2 3 4");
        for(int i= 0; i< 5; i++){
            System.out.print(i + " ");
            for(int j = 0;j<5;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public void Degree(int vertex){
        int count = 0;
        for (int i = 0; i<5; i++){
            if(matrix[vertex][i] == 1){
                count++;
            }
        }    
        System.out.println("Degree of Vertex " + vertex + " is: " + count);
    }
    public int CheckEdge(int source, int destination){
        return matrix[source][destination];
    }
    public static void main(String[] args) {
        GraphOperations G1 = new GraphOperations();
        G1.AddEdge(0, 1);
        G1.AddEdge(2, 1);
        G1.AddEdge(4, 2);
        G1.Display();
        G1.Degree(2);
        if (G1.CheckEdge(2, 4) == 1) {
            System.out.println("An edge exists between 2 and 4.");
        } else {
            System.out.println("No edge exists between 2 and 4.");
        }
        G1.RemoveEdge(0, 1);
        G1.Display();
    }
}
