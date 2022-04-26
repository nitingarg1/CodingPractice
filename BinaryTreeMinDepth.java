public class BinaryTreeMinDepth {
    int minDepth =Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
    minDepth(root,0);
    return minDepth;
    }

    public void minDepth(TreeNode root, int depth) {
            if(root==null){
                return ;
            }
            if(root.left==null && root.right==null)
                minDepth= Math.min(minDepth, depth);
            minDepth(root.left,depth+1);
            minDepth(root.right,depth+1);
    }
}
