import java.util.*;

public class MaximumWidthBinaryTree {
    public static void main(String[] args) {
        TreeNode t= new TreeNode(1);
        t.left=new TreeNode(3);
        t.right= new TreeNode(2);
        t.left.left= new TreeNode(5);
        t.left.right= new TreeNode(3);
        t.right.right= new TreeNode(9);
        System.out.println(new MaximumWidthBinaryTree().widthOfBinaryTree(t));
    }

    public class Pair {
        public TreeNode node;
        public int index;
        public Pair(TreeNode node, int index)
        {
            this.node=node;
            this.index=index;
        }
    }

//    public int widthOfBinaryTree(TreeNode root) {
//    if(root==null)
//        return 0;
//        Queue<Pair> bfsQueue = new LinkedList();
//        int maxLength=1;
//        Pair rootPair = new Pair(root,0);
//        bfsQueue.add(rootPair);
//        while(bfsQueue.size()>0){
//            int tempQueueSize = bfsQueue.size();
//            int tempMaxIndex=0;
//            int tempMinIndex= bfsQueue.peek().index;
//            while(tempQueueSize>0){
//                Pair polledPair =  bfsQueue.poll();
//                if(polledPair.node.left!=null){
//                    bfsQueue.add(new Pair(polledPair.node.left,2*polledPair.index+1));
//                }
//                if(polledPair.node.right!=null){
//                    bfsQueue.add(new Pair(polledPair.node.right,2*polledPair.index+2));
//                }
//                tempMaxIndex=polledPair.index;
//                tempQueueSize--;
//            }
//            maxLength=Math.max(maxLength,tempMaxIndex-tempMinIndex+1);
//
//        }
//        return maxLength;
//    }


    int max = 0;
    Map<Integer, Integer> leftPosition = new HashMap<>();
    public int widthOfBinaryTree(TreeNode root) {
        widthOfBinaryTree(root, 0, 0);
        return max;
    }

    public void widthOfBinaryTree(TreeNode root, int depth, int position) {
        if (root == null)
            return;
        int left = leftPosition.computeIfAbsent(depth, x -> position);
        max = Math.max(max, position - left + 1);
        widthOfBinaryTree(root.left, depth + 1, 2 * position);
        widthOfBinaryTree(root.right, depth + 1, 2 * position + 1);
    }

}
