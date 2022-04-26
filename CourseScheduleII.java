import java.util.*;
import java.util.stream.IntStream;

/**
 * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.
 *
 * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
 * Return the ordering of courses you should take to finish all courses. If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.
 *
 *
 *
 * Example 1:
 *
 * Input: numCourses = 2, prerequisites = [[1,0]]
 * Output: [0,1]
 * Explanation: There are a total of 2 courses to take. To take course 1 you should have finished course 0. So the correct course order is [0,1].
 * Example 2:
 *
 * Input: numCourses = 4, prerequisites = [[1,0],[2,0],[3,1],[3,2]]
 * Output: [0,2,1,3]
 * Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0.
 * So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3].
 * Example 3:
 *
 * Input: numCourses = 1, prerequisites = []
 * Output: [0]
 */
public class CourseScheduleII {
    public static void main(String[] args) {
        System.out.println(new CourseScheduleII().findOrder(4, new int[][]{{1,0},{2,0},{3,1},{3,2}}));
      //  System.out.println(new CourseScheduleII().findOrder(2, new int[][]{{1,0}}));
    }

//    public int[] findOrder(int numCourses, int[][] prerequisites) {
//
//    Set<Integer> result = new LinkedHashSet<>();
//    int[] visited = new int [numCourses];
//    Map<Integer, List<Integer>> prerequisitesMap = new HashMap<>();
//        for (int i :IntStream.range(0,numCourses).toArray())
//            prerequisitesMap.put(i,new ArrayList<>());
//
//    for(int[] dependency:prerequisites){
//        if(prerequisitesMap.get(dependency[0])==null){
//            prerequisitesMap.put(dependency[0],new ArrayList<>());
//        }
//        prerequisitesMap.get(dependency[0]).add(dependency[1]);
//    }
//    for(Map.Entry<Integer,List<Integer>> entry :prerequisitesMap.entrySet()){
//        if(!findOrder(visited,result,prerequisitesMap,entry.getKey())){
//            return new int[0];
//        }
//        }
//
//    return result.stream().mapToInt(i->i).toArray();
//    }
//
//    public boolean findOrder(int[] visited,Set<Integer> result,Map<Integer, List<Integer>> prerequisitesMap, int key){
//        if(visited[key]==1 ) {
//            result.add(key);
//            return true;
//        }
//        if(visited[key]==-1)
//            return false;
//        visited[key]=-1;
//        if(prerequisitesMap.get(key)!=null) {
//            for (Integer d : prerequisitesMap.get(key)) {
//                if (!findOrder(visited, result, prerequisitesMap, d))
//                    return false;
//            }
//        }
//        visited[key]=1;
//        result.add(key);
//        return true;
//    }

//    public List<Integer> findOrder(int numCourses, int[][] prerequisites) {
//        List<Integer> output = new ArrayList<>();
//        Map<Integer,List<Integer>> coursePrerequiset = new HashMap<>();
//        int [] degreeArray = new int[numCourses];
//        Queue<Integer> degreeQueue = new LinkedList<>();
//        for(int [] pre : prerequisites){
//            List<Integer> tempList = coursePrerequiset.getOrDefault(pre[1],new ArrayList<>());
//            tempList.add(pre[0]);
//            coursePrerequiset.put(pre[1],tempList);
//            degreeArray[pre[0]]+=1;
//        }
//
//
//        //add 0 degree to the queue
//        for(int i=0;i<degreeArray.length ;i++){
//            if(degreeArray[i]==0)
//                degreeQueue.add(i);
//        }
//
//        int count=0;
//        while(degreeQueue.size()!=0){
//            int temp = degreeQueue.poll();
//            output.add(temp);
//            if(coursePrerequiset.containsKey(temp)) {
//                for (int i : coursePrerequiset.get(temp)) {
//                    degreeArray[i]--;
//                    if (degreeArray[i] == 0)
//                        degreeQueue.add(i);
//                }
//            }
//        }
//        return output;
//    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int [] courseDegree = new int [numCourses] ;
        Set<Integer> course= new HashSet<>();
        //dependecyMap
        Map<Integer,List<Integer>> depMap = new HashMap<>();
        for(int [] t : prerequisites){
            List<Integer> tempList= depMap.getOrDefault(t[1],new ArrayList<Integer>());
            tempList.add(t[0]);
            courseDegree[t[0]]+=1;
            depMap.put(t[1],tempList);
        }
        //get the 0 degree course
        Queue<Integer> zerorD= new LinkedList<>();
        for(int i=0;i<courseDegree.length;i++){
            if(courseDegree[i]==0)
                zerorD.add(i);
        }
        int[] res= new int[numCourses];
        int count=0;
        //get the result
        while(zerorD.size()>0) {
            int c = zerorD.poll();
            if (!course.contains(c)) {
                res[count++] = c;
                for (int i : depMap.getOrDefault(c, new ArrayList<>())) {
                    courseDegree[i] -= 1;
                    if (courseDegree[i] == 0)
                        zerorD.add(i);
                }
                course.remove(c);
            }

        }
        return res;
    }
}
