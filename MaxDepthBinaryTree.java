public class MaxDepthBinaryTree {
    public static void main(String[] args) {

    }
    int maxDepth = 0;
    public int maxDepth(TreeNode root) {
        if(root==null)
            return maxDepth;
        maxDepth(root,0);
        return maxDepth;
    }

    public void maxDepth(TreeNode root, int depth){
        if(root==null)
            return;
        maxDepth= Math.max(maxDepth,depth+1);
        maxDepth(root.left,depth+1);
        maxDepth(root.right,depth+1);
    }
}
