import java.util.*;

public class BoundaryTraversal {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isLeaf(Node root){
        return root.left==null && root.right==null;
    }

    public static void addLeftBoundary(Node root, List<Integer> arr){
        Node curr = root.left;
        while(curr!=null){
            if(!isLeaf(curr)){
                arr.add(curr.data);
            }
            if(curr.left!=null){
                curr = curr.left;
            }else{
                curr = curr.right;
            }
        }
    }

    public static void addRightBoundary(Node root, List<Integer> arr) {
        Node curr = root.right;
        List<Integer> temp = new ArrayList<>();
        while (curr != null) {
            if (!isLeaf(curr)) {
                temp.add(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        //reverse and add
        for(int i=temp.size()-1; i>=0; i--){
            arr.add(temp.get(i));
        }
    }

    public static void addLeaves(Node root, List<Integer> arr){
        if(isLeaf(root)){
            arr.add(root.data);
            return;
        }

        if(root.left!=null){
            addLeaves(root.left, arr);
        }
        if(root.right!=null){
            addLeaves(root.right, arr);
        }
    }
    public static List<Integer> boundaryTraversal(Node root){
        List<Integer> arr = new ArrayList<>();
        if(root==null){
            return arr;
        }
        if(!isLeaf(root)){
            arr.add(root.data);
        }
        
        addLeftBoundary(root, arr);
        addLeaves(root, arr);
        addRightBoundary(root, arr);

        return arr;
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

        List<Integer> result = boundaryTraversal(root);

        for(int i=0; i<result.size(); i++){
            System.out.print(result.get(i) + " ");
        }
    }
}
