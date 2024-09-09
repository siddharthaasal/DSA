package BST;
import java.util.*;
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class TwoSumBST {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> arr = bstToSortedList(root);
        // via 2 pointer approach
        int start = 0, end = arr.size() - 1;
        int reqSum = k;
        while (start < end) {
            int sum = arr.get(start) + arr.get(end);
            if (sum > reqSum) {
                end--;
            } else if (sum < reqSum) {
                start++;
            } else {
                return true;
            }
        }
        return false;

    }

    public List<Integer> bstToSortedList(TreeNode root) {
        List<Integer> sortedList = new ArrayList<>();
        inOrderTraversal(root, sortedList);
        return sortedList;
    }

    private void inOrderTraversal(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        inOrderTraversal(node.left, list);
        list.add(node.val);
        inOrderTraversal(node.right, list);
    }
}