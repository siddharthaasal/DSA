import java.util.*;
public class RootToLeafPaths {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void printRecurPaths(List<Integer> path, Node curr){
        if(curr==null){
            return;
        }
        path.add(curr.data);
        //if leaf node
        if(curr.left==null && curr.right==null){
            printPath(path);
        }else{
            printRecurPaths(path, curr.left);
            printRecurPaths(path, curr.right);
        }

        //remove the curr node whilst going up
        path.remove(path.size()-1);
    }

    public static void printPath(List<Integer> path){
        for(int i=0; i<path.size(); i++){
            System.out.print(path.get(i) + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        List<Integer> path = new ArrayList<>();
        printRecurPaths(path, root);
    }
}
