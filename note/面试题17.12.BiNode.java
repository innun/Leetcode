import java.util.Deque;
import java.util.LinkedList;

// 递归
class Solution {
    TreeNode dummy = new TreeNode(-1);
    TreeNode prev = dummy;

    public TreeNode convertBiNode(TreeNode root) {
        inorder(root);
        return dummy.right;
    }

    public void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        prev.right = root;
        prev = root;
        prev.left = null;
        inorder(root.right);
    }
}

// 非递归
class Solution1 {
    TreeNode dummy = new TreeNode(-1);
    TreeNode prev = dummy;

    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode ptr = root;
        // 栈空的时候可能还有右子树没有处理，所以得判断ptr
        while (ptr != null || !stack.isEmpty()) {
            if (ptr == null) {
                ptr = stack.pop();
                ptr.left = null;
                prev.right = ptr;
                prev = ptr;
                ptr = ptr.right;
            } else {
                stack.push(ptr);
                ptr = ptr.left;
            }
        }
        return dummy.right;
    }
}