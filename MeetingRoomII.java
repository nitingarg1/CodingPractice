import java.util.*;

public class MeetingRoomII {

    public static class Interval {
      int start, end;
      Interval(int start, int end) {
          this.start = start;
          this.end = end;
      }
  }

    public static void main(String[] args) {
        MeetingRoomII m = new MeetingRoomII();
        List<Interval> list = new ArrayList<>();
        list.add(new MeetingRoomII.Interval(0,30));
        list.add(new MeetingRoomII.Interval(5,10));
        list.add(new MeetingRoomII.Interval(15,20));
        m.minMeetingRooms(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();

    }

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        PriorityQueue<Integer> meetingEndtime = new PriorityQueue<>();
        int maxRoom = 0;
        Collections.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return Integer.compare(o1.start,o2.start);
            }
        });
        for(Interval interval : intervals){
            while(meetingEndtime.size()!=0 && meetingEndtime.peek()<=interval.start){
                meetingEndtime.poll();
            }
            meetingEndtime.offer(interval.end);
            maxRoom= Math.max(maxRoom,meetingEndtime.size());
        }
        return maxRoom;
    }
}
