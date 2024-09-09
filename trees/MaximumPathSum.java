public class MaximumPathSum {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static int maxSum(Node root, int sum[]){
        if(root==null){
            return 0;
        }

        int leftSum = Math.max(0, maxSum(root.left, sum));
        int rightSum = Math.max(0,maxSum(root.right, sum));

        sum[0] = Math.max(sum[0], leftSum+rightSum+root.data);

        return Math.max(leftSum, rightSum) + root.data;       
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

        int sum[] = new int[1];
        sum[0] = Integer.MIN_VALUE;
        maxSum(root, sum);

        System.out.println("Maximum Path Sum: "+ sum[0]);
    }
}
