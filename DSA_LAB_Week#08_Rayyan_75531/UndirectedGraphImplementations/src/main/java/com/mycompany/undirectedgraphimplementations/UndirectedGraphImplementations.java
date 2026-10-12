/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.undirectedgraphimplementations;

/**
 *
 * @author MUHAMMAD RAYYAN
 */
public class UndirectedGraphImplementations {
    int[][] matrix = new int [5][5];
    
    public void AddEdge(int source, int destination){
        matrix[source][destination] = 1;
        matrix[destination][source] = 1;
    }
    
    public void display(){
        System.out.println("Adjacency Matrix:");
        System.out.println("  0 1 2 3 4");
        for (int i= 0; i<5; i++){
            System.out.print(i + " ");
            for(int j = 0; j< 5; j++){
                System.out.print( matrix[i][j] + " ");
            }
            System.out.println("");
        }
    }
    public void Degree(int vertex){
        int count = 0;
        for(int i = 0; i< 5; i++){
            if(matrix[vertex][i] == 1){
                count++;
            }
        }
        System.out.println("Degree of Vertex " + vertex + " is: " + count);
        
    }
    public static void main(String[] args) {
        UndirectedGraphImplementations G1 = new UndirectedGraphImplementations();
        G1.AddEdge(0, 1);
        G1.AddEdge(0, 2);
        G1.AddEdge(1, 2);
        G1.AddEdge(1, 3);
        G1.AddEdge(3, 4);
        
        G1.Degree(1);
        G1.Degree(2);
        
        G1.display();
    }
}
