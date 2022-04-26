import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Test {
    public static void main(String[] args) {
        Test t = new Test();
//        ArrayList l = new ArrayList<>();
//        l.add(1);l.add(2);l.add(3);
//        t.permute(l);
//        t.combine(3,2);
//      System.out.println(t.isNumber("0.1"));
//      TreeNode test = new TreeNode(1);
//        test.left = new TreeNode(2);
//        test.right = new TreeNode(5);
//        test.left.left = new TreeNode(3);
//        test.left.right = new TreeNode(4);
//        test.right.right = new TreeNode(6);
//        t.flatten(test);
        t.nextPermutation(new int[]{1,3,2});
    }
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> A) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        permute(A,0,res);
        return res;
    }

    public void  permute(ArrayList<Integer> A,int index,ArrayList<ArrayList<Integer>> res) {
        if(index==A.size()){
            res.add((ArrayList<Integer>)A.clone());
            return;
        }
        int first=A.get(index);
        for(int i=index;i<A.size();i++){
            int second=A.get(i);
            A.set(index,second);
            A.set(i,first);
            permute(A,index+1,res);
            A.set(i,second);
            A.set(index,first);
        }
    }

    public ArrayList<ArrayList<Integer>> combine(int A, int B) {
        Integer [] combination = new Integer[B];
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        combine(A,1,combination,0,res,B);
        return res;
    }

    public void combine(int A, int start,Integer [] combination,int index,ArrayList<ArrayList<Integer>> res, int B){
        if(index==B){
            res.add( new ArrayList(Arrays.asList(combination)));
            return;
        }
        for(int i=start;(i+B-index-1)<=A;i++){
            combination[index]=i;
            combine(A,i+1,combination,index+1,res,B);
        }
    }

    public int isNumber(final String A) {
        if(A==null)
            return 0;
        if(checkStart(A)==1)
            return checkStart(A,1,false,false);
        return checkStart(A,0,false,false);
    }

    public int checkStart(String A){
        char c = A.charAt(0);
        if (c=='+' || c=='-' || c=='.')
            return 1;
        else
            return 0;
    }

    public int checkStart(String A, int index, boolean d, boolean e){
        if(index>=A.length())
            return 1;
        char c=A.charAt(index);
        if(c=='.' && (!d && !e))
            return checkStart(A,index+1,true,e);
        if(c=='e' && !d && !e)
            return checkStart(A,index+1,true,e);
        if(c<='9' && c>='0')
            return checkStart(A,index+1,d,e);
        return 0;

    }

    public void flatten(TreeNode a) {
//        TreeNode d = new TreeNode(-1);
        TreeNode res = new TreeNode(-1);
        Stack<TreeNode> stack= new Stack<>();
        stack.add(a);
        while(stack.size()>0){
            TreeNode temp = stack.pop();
            res.right=temp;
            res=temp;
            if(temp.right!=null) {
                stack.add(temp.right);
                temp.right=null;
            }if(temp.left!=null) {
                stack.add(temp.left);
                temp.left=null;
            }

        }
    }

    public void nextPermutation(int[] nums) {
        int changingOrderIndex =0;
        for(int i=nums.length-1;i>0;i--){
            if(nums[i]>nums[i-1]){
                changingOrderIndex=i;
                break;
            }
        }
        reverseArray(nums,changingOrderIndex,nums.length-1);
        if(changingOrderIndex>0){
            swapArray(nums,changingOrderIndex-1,nums.length-1);
        }

    }

    public void reverseArray(int [] arr, int s, int e){
        while(s<e){
            swapArray(arr,s,e);
            s++;e--;
        }
    }
    public void swapArray(int [] arr, int f, int s){
        int t1=arr[s];
        arr[s]=arr[f];
        arr[f]=t1;
    }
}


