public class JumpGame3 {
    public static void main(String[] args) {
        System.out.println(new JumpGame3().canReach(new int[]{4,2,3,0,3,1,2},5));
    }
    public boolean canReach(int[] arr, int start) {
    boolean [] visited = new boolean[arr.length];
    return canReach(arr,start,visited);
    }

    public boolean canReach(int[] arr, int start, boolean[] visited){
        boolean res = false;
        if(arr==null || arr.length<1 || visited[start]){
            return false ;
        }
        if(arr[start]==0){
            return true;
        }
        int l = start-arr[start];
        int r = start+arr[start];
        visited[start] = true;
        if(l>=0){
            res |= canReach(arr,l,visited);
        }
        if(r<arr.length){
            res |= canReach(arr,l,visited);
        }
        return res;
    }
}
