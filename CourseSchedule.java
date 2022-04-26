import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule {
    public static void main(String[] args) {
        System.out.println( new CourseSchedule().canFinish(2, new int[][]{{1,0},{0,1}}));
    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, List<Integer>> preRequisitMap = new HashMap<>();
        int visited[] = new int[numCourses];
        //prepare pre-requisit map
        for(int[] pre : prerequisites){
            if(preRequisitMap.get(pre[0])==null){
                preRequisitMap.put(pre[0],new ArrayList<>());
            }
            preRequisitMap.get(pre[0]).add(pre[1]);
        }
        for(Map.Entry<Integer,List<Integer>> entry :preRequisitMap.entrySet()){
            if(!canFinish(preRequisitMap,visited,entry.getKey()))
                return false;
        }
        return true;
    }

    public boolean canFinish(Map<Integer, List<Integer>> preRequisitMap, int visited[], Integer course){
        if(visited[course]==1)
            return true;
        if(visited[course]==-1)
            return false;
        visited[course]=-1;
        if(preRequisitMap.get(course)!=null) {
            for (Integer i : preRequisitMap.get(course)) {
                if(!canFinish(preRequisitMap, visited, i))
                    return false;

            }
        }
        visited[course]=1;
        return true;
    }
}
