import java.util.LinkedList;
import java.util.Queue;

public class MaxWidth {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }
    static class Pair{
        Node node;
        int index;
        public Pair(Node node, int index){
            this.node = node;
            this.index = index;
        }
    }

    public static int maxWidth(Node root){
        if(root==null){
            return 0;
        }
        int width = 0;
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(root, 0));

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int firstIndex = 0;
            int lastIndex = firstIndex;
            int minInLevel = queue.peek().index;

            for(int i=0; i<levelSize; i++){
                int currentId = queue.peek().index - minInLevel;
                Node current = queue.peek().node;
                queue.poll();

                if(i==0){
                    firstIndex = currentId;
                }
                if(i==levelSize-1){
                    lastIndex = currentId;
                }

                if(current.left!=null){
                    queue.add(new Pair(current.left, currentId*2+1));
                }
                if(current.right!=null){
                    queue.add(new Pair(current.right, currentId*2+2));
                }
            }
            width = Math.max(width, lastIndex-firstIndex+1);
        }
        return width;
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

        System.out.println("Max width: "+ maxWidth(root));
    }
}
