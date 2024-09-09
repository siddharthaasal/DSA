public class SymmetricTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static boolean isSymmetricHelper(Node left, Node right){
        if(left==null || right==null){
            return left==right;
        }
        if(left.data != right.data){
            return false;
        }

        return isSymmetricHelper(left.left, right.right) && isSymmetricHelper(left.right, right.left);
    }
    public static boolean isSymmetricTree(Node root){
        return root==null || isSymmetricHelper(root.left, root.right);
    }

    public static void main(String[] args) {
        /*
         * 1
         * / \
         * 2 3
         * / \ / \
         * 4 5 6 7
         */

        // Node root = new Node(1);
        // root.left = new Node(2);
        // root.right = new Node(3);
        // root.left.left = new Node(4);
        // root.left.right = new Node(5);
        // root.right.left = new Node(6);
        // root.right.right = new Node(7);

        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        boolean flag = isSymmetricTree(root);

        if(flag){
            System.out.println("Yes, Symmetric");
        }else{
            System.out.println("Not Symmetric");
        }
    }
}
