public class HouseRobberIII {
    /**
     * 337. House Robber III
     * The thief has found himself a new place for his thievery again. There is only one entrance to this area, called root.
     *
     * Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that all houses in this place form a binary tree. It will automatically contact the police if two directly-linked houses were broken into on the same night.
     *
     * Given the root of the binary tree, return the maximum amount of money the thief can rob without alerting the police.
     *
     *
     *
     * Example 1:
     *
     *
     * Input: root = [3,2,3,null,3,null,1]
     * Output: 7
     * Explanation: Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.
     * Example 2:
     *
     *
     * Input: root = [3,4,5,1,3,null,1]
     * Output: 9
     * Explanation: Maximum amount of money the thief can rob = 4 + 5 = 9.
     *
     *
     *
     */

    /**
     * There are only 2 cases, wither u can have total withroot or withoutroot.
     * Recursively calculate thar and comeup with the max value
     * at 0 we are getting with root and at 1 we are getting withoutRoot
     *
     */
    public int rob(TreeNode root) {
        int[] res =checkMax(root);

    return Math.max(res[0],res[1]);
    }

    public int[] checkMax(TreeNode root){
        int [] res = new int[2];
        if (root==null)
            return res;
        int [] left = checkMax(root.left);
        int [] right = checkMax(root.right);
        res[0] = root.val+left[1]+right[1];
        res[1] = Math.max(left[0],left[1])+ Math.max(right[0],right[1]);
        return res;
    }
}
