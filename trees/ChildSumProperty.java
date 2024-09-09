import java.util.LinkedList;
import java.util.Queue;

public class ChildSumProperty {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void reorderTree(Node root){
        if(root==null){
            return;
        }
        int child = 0;
        if(root.left!=null){
            child += root.left.data;
        }
        if(root.right!=null){
            child += root.right.data;
        }

        if(child >= root.data){
            root.data = child;
        }else{
            if(root.left!=null){
                root.left.data = root.data;
            }
            if(root.right!=null){
                root.right.data = root.data;
            }
        }

        reorderTree(root.left);
        reorderTree(root.right);

        int tot = 0;
        if (root.left != null) {
            tot += root.left.data;
        }
        if (root.right != null) {
            tot += root.right.data;
        }

        if(root.left!=null || root.right!=null){
            root.data = tot;
        }
    }

    public static void levelOrderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");

                if (curr.left != null) {
                    queue.add(curr.left);
                }

                if (curr.right != null) {
                    queue.add(curr.right);
                }
            }
            System.out.println();
        }
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

        System.out.println("Original tree:");
        levelOrderTraversal(root);

        System.out.println("After children sum reorder");
        reorderTree(root);
        levelOrderTraversal(root);
    }
}

