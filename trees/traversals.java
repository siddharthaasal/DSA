import java.util.*;

import javax.swing.tree.TreeNode;
import javafx.util.Pair;

class traversals {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    
    static class Pair<K, V> {
        private K key;
        private V value;

        public Pair(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }
    }

    public static void preorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preorderTraversal(root.left);
        preorderTraversal(root.right);
    }

    public static void inorderTraversal(Node root) {
        if (root == null) {
            // System.out.println();
            return;
        }
        inorderTraversal(root.left);
        System.out.print(root.data + " ");
        inorderTraversal(root.right);
    }

    public static void postorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        System.out.print(root.data + " ");
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

    public static void zigZagTraversal(Node root) {
        if (root == null) {
            return;
        }
        boolean leftToRight = false;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                Node curr = queue.poll();
                System.out.print(curr.data + " ");
                if (leftToRight) {
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }

                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                } else {
                    if (curr.right != null) {
                        queue.add(curr.right);
                    }
                    if (curr.left != null) {
                        queue.add(curr.left);
                    }
                }

            }
            leftToRight = !leftToRight;
            System.out.println();

        }
    }

    public static void iterativePreorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pop();
            System.out.print(curr.data + " ");
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }

        }

    }

    public static void iterativeInorderTraversal(Node root) {
        if (root == null) {
            return;
        }
        Stack<Node> stack = new Stack<>();
        Node curr = root;

        while (curr != null || !stack.isEmpty()) {
            // go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // now the leftmost node is null,
            // pop the left most node
            // traverse to right subtree
            curr = stack.pop();
            System.out.print(curr.data + " ");

            curr = curr.right;
        }
    }

    public static void iterativePostorderTraversal(Node root) {
        if (root == null) {
            return;
        }

        Stack<Node> stack = new Stack<>();
        Node curr = root;
        Node prev = null; // previous node to track the last visited node

        while (!stack.isEmpty() || curr != null) {
            // Go to the leftmost node
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }

            // Peek at the top of the stack without popping it
            curr = stack.peek();

            // If the right child is null or already visited, process the root
            if (curr.right == null || curr.right == prev) {
                System.out.println(curr.data); // Visit the root
                stack.pop();
                prev = curr; // Mark the current node as visited
                curr = null; // Reset curr to avoid revisiting left subtree
            } else {
                // Otherwise, move to the right subtree
                curr = curr.right;
            }
        }
    }

    public static List<List<Integer>> verticalTraversal(Node root) {
        Map<Integer, Map<Integer, TreeSet<Integer>>> map = new TreeMap<>();
        Queue<Pair<Node, Pair<Integer, Integer>>> queue = new LinkedList<>();

        queue.add(new Pair<>(root, new Pair<>(0, 0)));

        while (!queue.isEmpty()) {
            Pair<Node, Pair<Integer, Integer>> p = queue.poll();
            int x = p.getValue().getKey();
            int y = p.getValue().getValue();
            map.computeIfAbsent(x, k-> new , null)

        }
    }

    // }

    public static void main(String args[]) {
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

        System.out.println("Pre Order Traversal");
        preorderTraversal(root);
        System.out.println();
        System.out.println("In Order Traversal");
        inorderTraversal(root);
        System.out.println();
        System.out.println("Post Order Traversal");
        postorderTraversal(root);
        System.out.println();
        System.out.println("Level Order Traversal");
        levelOrderTraversal(root);
        System.out.println();
        System.out.println("Zig Zag Level Order Traversal");
        zigZagTraversal(root);
        System.out.println();
        System.out.println("Iterative Pre Order Traversal");
        iterativePreorderTraversal(root);
        System.out.println();
        System.out.println("Iterative In Order Traversal");
        iterativeInorderTraversal(root);
        System.out.println();
        System.out.println("Iterative Post Order Traversal");
        iterativePostorderTraversal(root);
    }
}