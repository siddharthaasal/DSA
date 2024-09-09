package dsa.graphs;

import java.util.*;

public class Template {

    static class Graph {
        int vertices;
        LinkedList<Integer> adjList[];
        
        Graph(int vertices){
            this.vertices = vertices;
            for(int i=0; i<vertices; i++){
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest){
            adjList[src].add(dest);
            adjList[dest].add(src);
        }
        
    }

    public static void main(String[] args) {
        Graph graph = new Graph(5);

        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
    }
    
}