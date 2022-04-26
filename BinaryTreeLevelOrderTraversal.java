import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelorder(TreeNode root){
        List<List<Integer>> outPut = new ArrayList<>();

        if(root==null)
            return outPut;

        Queue<TreeNode> treeNodeQ = new LinkedList<>();
        treeNodeQ.add(root);
        while(treeNodeQ.size()>0){
            Queue<TreeNode> innerQ = new LinkedList<>();
            List<Integer> res= new ArrayList<>();
            while(treeNodeQ.size()>0){
                TreeNode temp = treeNodeQ.poll();
                if(temp.left!=null)
                    innerQ.offer(temp.left);
                if(temp.right!=null)
                    innerQ.offer(temp.right);
                res.add(temp.val);
            }
            outPut.add(res);
            treeNodeQ=innerQ;
        }
        return outPut;
    }


}
