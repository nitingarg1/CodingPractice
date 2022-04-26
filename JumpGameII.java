public class JumpGameII {
    public static void main(String[] args) {
        System.out.println(new JumpGameII().jump(new int []{2,1}));
    }

    public int jump(int[] nums) {
        if(nums==null|| nums.length<2){
            return 0;
        }
     return jump(nums,0,new Integer[nums.length])  ;
    }

//    public int jump (int [] nums, int start, Integer [] minStepArray){
//        int minStep = Integer.MAX_VALUE;
//        if(start >nums.length-1){
//            return minStep ;
//        }
//        if(minStepArray[start]!=null){
//            return minStepArray[start];
//        }
//        if(start+nums[start]>=nums.length-1){
//            minStepArray[start]=1;
//            return  minStepArray[start];
//        }
//        int step = nums[start];
//        for(int i=1; i<=step;i++){
//            minStep= Math.min(minStep,jump(nums, start+i,minStepArray));
//        }
//        minStepArray[start]=Math.max(minStep,minStep+1);
//        return  minStepArray[start];
//    }

    private int jump(int [] nums, int start,Integer minJump[]){
        int minStep = Integer.MAX_VALUE;
        if(start>=nums.length)
            return minStep;
        if(start+nums[start]>=nums.length-1) {
            minJump[start]=1;
            return minJump[start];
        }

        int step=nums[start];

        for(int i=1;i<=step;i++)
            minStep= Math.min(minStep,jump(nums,start+i,minJump));
        minJump[start]=Math.max(minStep,minStep+1);
        return  minJump[start];


    }
}
