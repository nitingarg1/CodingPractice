public class LowestCommonAncestralBinaryTree {
    public static void main(String[] args) {
    TreeNode root= new TreeNode(3);

    root.left=new TreeNode(5);
    root.left.left= new TreeNode(6);
    root.left.right=new TreeNode(2);
    root.left.right.left = new TreeNode(7);
    root.left.right.right = new TreeNode(4);

    root.right= new TreeNode(1);
    root.right.left= new TreeNode(0);
    root.right.right= new TreeNode(8);
    new LowestCommonAncestralBinaryTree().lowestCommonAncestor(root, new TreeNode(5),new TreeNode(4));
    }

    TreeNode ans;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        lca( root, p, q);
        return ans;
    }

    public int lca(TreeNode root, TreeNode p, TreeNode q){
        if(root==null)
            return 0;
        int l = lca(root.left, p, q);
        int r = lca(root.right, p, q);
        int m = (root.val==p.val || root.val==q.val)?1:0;
        if(l+r+m>=2)
            ans=root;
        return l+r+m>0?1:0;
    }
}
