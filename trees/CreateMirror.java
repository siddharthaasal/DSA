
class Node {
    int data;
    Node left, right;

    Node(int item) {
        data = item;
        left = right = null;
    }
}

class CreateMirror {
    void mirror(Node node) {
        // Your code here
        helper(node);
    }

    private static Node helper(Node root){
        if(root == null){
            return null;
        }

        Node left = helper(root.left);
        Node right = helper(root.right);

        root.left = right;
        root.right = left;

        return root;
    }
}