import java.util.*;

public class Views {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    static class Pair {
        Node node;
        int hd;

        Pair(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }

    public static List<Integer> topView(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int line = pair.hd;

            if (!map.containsKey(line)) {
                map.put(line, node.data);
            }

            if (node.left != null) {
                queue.add(new Pair(node.left, line - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, line + 1));
            }
        }

        for (int value : map.values()) {
            ans.add(value);
        }
        return ans;
    }

    public static List<Integer> bottomView(Node root) {
        List<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }

        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> queue = new LinkedList<>();

        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            Pair pair = queue.poll();
            Node node = pair.node;
            int line = pair.hd;

            map.put(line, node.data);

            if (node.left != null) {
                queue.add(new Pair(node.left, line - 1));
            }
            if (node.right != null) {
                queue.add(new Pair(node.right, line + 1));
            }
        }

        for (int value : map.values()) {
            ans.add(value);
        }
        return ans;
    }

    public static void leftViewHelper(Node root, int level, List<Integer> ans){
        if(root == null){
            return;
        }
        if(level == ans.size()){
            ans.add(root.data);
        }
        leftViewHelper(root.left, level+1, ans);
        leftViewHelper(root.right, level + 1, ans);
    }
    public static List<Integer> leftView(Node root){
        List<Integer> ans = new ArrayList<>();
        leftViewHelper(root, 0, ans);
        return ans;
    }

    public static void rightViewHelper(Node root, int level, List<Integer> ans) {
        if (root == null) {
            return;
        }
        if (level == ans.size()) {
            ans.add(root.data);
        }
        rightViewHelper(root.right, level + 1, ans);
        rightViewHelper(root.left, level + 1, ans);
    }

    public static List<Integer> rightView(Node root) {
        List<Integer> ans = new ArrayList<>();
        rightViewHelper(root, 0, ans);
        return ans;
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

        List<Integer> topView = topView(root);
        System.out.println("Top View: ");
        for (int node : topView) {
            System.out.print(node + " ");
        }

        List<Integer> bottomView = bottomView(root);
        System.out.println("\nBottom View: ");
        for (int node : bottomView) {
            System.out.print(node + " ");
        }

        List<Integer> leftView = leftView(root);
        System.out.println("\n Left View: ");
        for (int node : leftView) {
            System.out.print(node + " ");
        }

        List<Integer> rightView = rightView(root);
        System.out.println("\n Right View: ");
        for (int node : rightView) {
            System.out.print(node + " ");
        }
    }
}
