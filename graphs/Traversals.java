package dsa.graphs;

import java.util.*;

public class Traversals {

    static class Graph {
        int vertices;
        LinkedList<Integer> adjList[];

        @SuppressWarnings("unchecked")
        Graph(int vertices) {
            this.vertices = vertices;
            adjList = new LinkedList[vertices];
            for (int i = 0; i < vertices; i++) {
                adjList[i] = new LinkedList<>();
            }
        }

        public void addEdge(int src, int dest) {
            adjList[src].add(dest);
            adjList[dest].add(src);
        }

        public void BFS(int startVertex){
            boolean[] visited = new boolean[vertices];
            Queue<Integer> queue = new LinkedList<>();
            visited[startVertex] = true;
            queue.add(startVertex);

            while(!queue.isEmpty()){
                int curr = queue.poll();
                System.out.print(curr + " ");

                for(int i=0; i<adjList[curr].size(); i++){
                    int adjacentVertex = adjList[curr].get(i);
                    if(visited[adjacentVertex] == false){
                        visited[adjacentVertex] = true;
                        queue.add(adjacentVertex);
                    }
                }
            }
        } 

        public void DFS(int startVertex){
            boolean[] visited = new boolean[vertices];
            DFSUtil(startVertex, visited);
        }

        public void DFSUtil(int  vertex, boolean visited[]){
            visited[vertex] = true;
            System.out.print(vertex + " ");
            for(int i=0; i<adjList[vertex].size(); i++){
                if(visited[adjList[vertex].get(i)]==false){
                    DFSUtil(adjList[vertex].get(i), visited);
                }
            }
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

        graph.BFS(0);
        System.out.println();
        graph.DFS(0);
    }

}