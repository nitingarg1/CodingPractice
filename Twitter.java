import java.util.*;

public class Twitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 1 tweet id -> [5]. return [5]
        twitter.follow(1, 2);    // User 1 follows user 2.
        twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
        twitter.getNewsFeed(1);  // User 1's news feed should return a list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet id 5 because it is posted after tweet id 5.
        twitter.unfollow(1, 2);  // User 1 unfollows user 2.
        twitter.getNewsFeed(1);
    }
    Map<Integer,User> userMap;
    int MaxRecentTweet = 10;
    Long timestamp = new Long(1);
    public Twitter() {
    userMap = new HashMap<>();
    }

    public void postTweet(int userId, int tweetId) {
        User u = getUser(userId);;
        Tweet t = new Tweet(tweetId,++timestamp);
        u.addTweet(t);
    }

    public List<Integer> getNewsFeed(int userId) {
        User u = userMap.get(userId);
        if(u==null)
            return new ArrayList<Integer>();
        List<Integer> newsFeedList = new LinkedList<>();
        Queue<Tweet> tweetPriorityQueue = new PriorityQueue<>((o1,o2)->o2.timeStanp.compareTo(o1.timeStanp));
        if(u.tweetHead.next!=null)
            tweetPriorityQueue.add(u.tweetHead.next);
        for(int followee : u.follows){
            User tempuser = userMap.get(followee);
            if(tempuser.tweetHead.next!=null)
                tweetPriorityQueue.add(tempuser.tweetHead.next);
        }
        int count=0;
        while(count<MaxRecentTweet && tweetPriorityQueue.size()>0){
            Tweet temp= tweetPriorityQueue.poll();
            newsFeedList.add(temp.tweetId);
            if(temp.next!=null)
                tweetPriorityQueue.offer(temp.next);
        }
        return newsFeedList;
    }

    public void follow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.addFollower(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        User follower = getUser(followerId);
        User followee = getUser(followeeId);
        follower.removeFollower(followeeId);
    }

    public User getUser(int userId){
        if(!userMap.containsKey(userId)){
            userMap.put(userId,new User(userId));
        }
        return userMap.get(userId);
    }

    public class User{
       private int userId;
       private Set<Integer> follows;
       private Tweet tweetHead;

        public User( int userId){
            this.userId=userId;
            tweetHead=new Tweet(-1,new Long(-1));
            this.follows= new HashSet<>();
        }

        public void addTweet(Tweet t){
           t.next=tweetHead.next;
           tweetHead.next=t;
        }

        public void addFollower(int userId){
            follows.add(userId);
        }

//        public LinkedList<Tweet> getTweet(){
//            return tweetList;
//        }

        public void removeFollower(int userId){
            follows.remove(userId);
        }
    }

    public class Tweet{
        int tweetId;
        Long timeStanp;
        Tweet next;

        public Tweet(int tweetId, Long timeStanp){
            this.tweetId = tweetId;
            this.timeStanp=timeStanp;
        }
    }
}
