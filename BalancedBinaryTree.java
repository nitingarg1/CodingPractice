public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        isBalanced(root,0);
        return balanced;
    }
    boolean balanced = true;
    public int isBalanced(TreeNode root, int depth) {
        if(root==null)
            return depth;
        int leftDepth = isBalanced(root.left,depth+1);
        int rightDepth = isBalanced(root.right,depth+1);
        balanced=balanced && (Math.abs(leftDepth-rightDepth))<=1;
        return Math.max(leftDepth,rightDepth);
    }
}
