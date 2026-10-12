/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.directedgraph;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class DirectedGraph {
    int[][] matrix = new int[5][5];
    public void AddEdge(int source, int destination){
        matrix[source][destination] = 1;
    }
    public void InDegree(int vertex) {
        int count = 0;
        for(int i=0; i<5; i++){
            if (matrix[i][vertex]==1){
                count++;
            }
        }
        System.out.println("Indegree of Vertex " + vertex + ": " + count);
    }
    public void OutDegree(int vertex) {
        int count = 0;
        for(int i=0; i<5; i++){
            if (matrix[vertex][i]==1){
                count++;
            }
        }
        System.out.println("Outdegree of Vertex " + vertex + ": " + count);
    }
    public void Display(){
        System.out.println("Adjacency Matrix: ");
        System.out.println("  0 1 2 3 4");
        for(int i =0; i<5;i++){
            System.out.print(i+ " ");
            for(int j=0; j<5;j++){
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public static void main(String[] args) {
        DirectedGraph G1 = new DirectedGraph();
        G1.AddEdge(0, 1);
        G1.AddEdge(0, 2);
        G1.AddEdge(1, 2);
        G1.AddEdge(2, 3);
        G1.AddEdge(3, 1);

        G1.Display();
        System.out.println("\nVertex Degrees:");

        for(int i=0; i<5;i++){
            G1.InDegree(i);
            G1.OutDegree(i);
            System.out.println();
        }
    }
}
