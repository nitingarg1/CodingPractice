import apple.laf.JRSUIUtils;

public class RecoverBinarySearchTree {
    public static void main(String[] args) {
        TreeNode first= new TreeNode(3);
        first.left= new TreeNode(1);
        first.right=new TreeNode(4);
        first.right.left=new TreeNode(2);
        new RecoverBinarySearchTree().recoverTree(first);
    }

    TreeNode first ;
    TreeNode second;
    public void recoverTree(TreeNode root) {
        TreeNode pre = null;
        dfs(root);
        int temp = first.val;
        first.val=second.val;
        second.val=temp;
    }

    public void dfs(TreeNode root){
        if(root==null)
            return;
        dfs(root.left);
        TreeNode pre= root;
        if(root.left!=null && root.left.val> pre.val)
            first = root;
        if(root.right!=null && root.right.val< pre.val)
            second = root;
        dfs(root.right);
    }
}
