class Solution {
    public TreeNode convertBiNode(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode l = convertBiNode(root.left);
        TreeNode r = convertBiNode(root.right);
        root.left = null;

        if (l == null) {
            root.right = r;
            return root;
        } else {
            TreeNode p = l;
            while (p.right != null) {
                p = p.right;
            }
            p.right = root;
            root.right = r;
            return l;
        }
    }
}