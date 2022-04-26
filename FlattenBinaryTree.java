import java.util.Stack;

public class FlattenBinaryTree {
    public void flatten(TreeNode a) {
        if(a==null)
            return;
        TreeNode sentinel = new TreeNode();
        TreeNode head = sentinel;
        Stack<TreeNode> st = new Stack<>();
        st.add(a);
        while(st.size()>0){
            TreeNode temp = st.pop();
            head.right=temp;
            head=head.right;
            if(temp.right!=null)
                st.add(temp.right);
            if(temp!=null){
                st.add(temp.left);
            }
            temp.right=null;
            temp.left=null;

        }
    }

}
