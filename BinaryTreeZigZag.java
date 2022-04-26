import java.util.*;

public class BinaryTreeZigZag {

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left= new TreeNode(2);
        node.left.left= new TreeNode(4);
        node.right= new TreeNode(3);
        node.right.right = new TreeNode(5);
        new BinaryTreeZigZag().zigzagLevelOrder(node);
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> outPut = new ArrayList<>();
        if(root==null)
            return outPut;

        Deque<TreeNode> outerD = new LinkedList<>();
        //to decide start-end
        boolean order=false;
        outerD.offer(root);
        while(outerD.size()>0){
            Deque<TreeNode> innerD = new LinkedList<>();
            List<Integer> tempRes= new ArrayList<>();
            while(outerD.size()>0){
                TreeNode temp = outerD.pollFirst();
                tempRes.add(temp.val);
                if(order){
                    if(temp.left!=null)
                    innerD.addLast(temp.left);
                    if(temp.right!=null)
                        innerD.addLast(temp.right);
                }else{
                    if(temp.left!=null)
                        innerD.addFirst(temp.left);
                    if(temp.right!=null)
                        innerD.addFirst(temp.right);
                }


            }
            outerD=innerD;
            order=!order;
            outPut.add(tempRes);
        }
    return outPut;
    }
}
