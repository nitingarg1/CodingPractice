public class BinaryPathSum {
    public static void main(String[] args) {

    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        if(root.left==null && root.right==null && targetSum==0)
            return true;
        return hasPathSum(root.left,targetSum-root.val) || hasPathSum(root.right,targetSum-root.val);

    }
}
