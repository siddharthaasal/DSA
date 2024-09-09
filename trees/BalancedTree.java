public class BalancedTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int isBalanced(Node root){
        if(root == null){
            return 0;
        }
        int lh = isBalanced(root.left);
        int rh = isBalanced(root.right);

        if(lh==-1 || rh ==-1){
            return -1;
        }

        if(Math.abs(lh-rh)>1){
            return -1;
        }

        else{
            return Math.max(lh, rh) + 1;
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

        int h = isBalanced(root);

        if(h>=0){
            System.out.println("Balanced");
        }else{
            System.out.println("Not balanced");
        }
    }
}
