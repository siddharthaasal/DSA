import java.util.*;
public class NodesAtDistanceK {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static void markParents(Node root, Map<Node, Node> parentTrack){
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            Node curr = queue.poll();
            if(curr.left!=null){
                parentTrack.put(curr.left, curr);
                queue.add(curr.left);
            }
            if (curr.right != null) {
                parentTrack.put(curr.right, curr);
                queue.add(curr.right);
            }

        }
    }
    
    public static List<Integer> distanceK(Node root, Node target, int k){
        Map<Node, Node> parentTrack = new HashMap<>();
        markParents(root, parentTrack);
        Map<Node, Boolean> isVisited = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        int currentLevel = 0;

        queue.add(target);
        isVisited.put(target, true);

        while (!queue.isEmpty()) {
            int size = queue.size();
            if(currentLevel==k){
                break;
            }
            currentLevel++;
            for(int i=0; i<size; i++){
                Node curr = queue.poll();
                if(curr.left!=null && isVisited.get(curr.left)==null){
                    queue.add(curr.left);
                    isVisited.put(curr.left, true);
                }
                if (curr.right != null && isVisited.get(curr.right) == null) {
                    queue.add(curr.right);
                    isVisited.put(curr.right, true);
                }
                if(parentTrack.get(curr) !=null && isVisited.get(parentTrack
                
                .get(curr))==null){
                    queue.add(parentTrack.get(curr));
                    isVisited.put(parentTrack.get(curr), true);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            list.add(curr.data);
        }
        return list;

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


        System.out.println("Node at a level distance: ");
        List<Integer> list = distanceK(root, root.right, 1);
        for(int i=0; i<list.size(); i++){
            System.out.println(list.get(i));
        }
    }
}
