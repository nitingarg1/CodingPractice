import java.util.*;

public class ReconstructItenary {
    public static void main(String[] args) {
        System.out.println(new ReconstructItenary().findItinerary(new String[][] {{"JFK","KUL"},{"JFK","NRT"},{"NRT","JFK"}}));
    }

    public List<String> findItinerary(String[][] tickets) {

        //generate Map with from and to
        Map<String, PriorityQueue<String>>  iternaryMap = new HashMap<>();
        List<String> result = new ArrayList<>();

        for(String[] ticket : tickets) {
            if (iternaryMap.get(ticket[0]) == null)
                iternaryMap.put(ticket[0], new PriorityQueue<String>(new Comparator<String>() {
                    public int compare(String s1, String s2) {
                        return s1.compareTo(s2) * 1;
                    }
                }));
            iternaryMap.get(ticket[0]).offer(ticket[1]);
        }
            String pre = "JFK";
            while(iternaryMap.get(pre)!=null && iternaryMap.get(pre).size()>0){
                String nextHop = iternaryMap.get(pre).poll();
                result.add(pre);
                pre=nextHop;
            }
        result.add(pre);
        return result;
    }
}
