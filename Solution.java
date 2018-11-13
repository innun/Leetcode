import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode pruneTree(TreeNode root) {
        if (!has1(root)) {
            root = null;
            return root;
        } else {
            pruneTree(root.left);
            pruneTree(root.right);
            return root;
        }
    }

    boolean has1(TreeNode node) {
        if (node == null) {
            return false;
        }
        if (node.val == 1) {
            return true;
        } else{
            return has1(node.left) && has1(node.right);
        }
    }
}