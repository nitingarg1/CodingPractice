import java.util.ArrayList;
import java.util.List;

public class PathSumII {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        pathSum( root,  targetSum, new ArrayList<Integer>());
        return result;
    }

    public void pathSum( TreeNode root, int targetSum, List<Integer> interinList){
        if(root == null)
            return;
        interinList.add(root.val);
        if(targetSum==root.val && root.left==null && root.right==null) {
            result.add(new ArrayList<>(interinList));
        }
        int size= interinList.size()-1;;
        pathSum( root.left,  targetSum-root.val, interinList);
        pathSum( root.right,  targetSum-root.val, interinList);
        interinList.remove(size);
    }
}
