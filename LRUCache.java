import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    public class LRUCacheNode{
        int val;
        int key;
        LRUCacheNode next;
        LRUCacheNode pre;
    }

    int maxCapacity=-1;
    int presentCapacity;
    LRUCacheNode head= new LRUCacheNode();
    LRUCacheNode tail= new LRUCacheNode();
    Map<Integer,LRUCacheNode> NodeMap = new HashMap<>();


    public LRUCache(int c){
        this.maxCapacity=c;
        head.next=tail;
        tail.pre=head;
    }

    public Integer get(int key){
        if(NodeMap.get(key)==null)
            return null;
        LRUCacheNode node = NodeMap.get(key);
        moveToFront(node);
        return node.val;
    }

    public void put(int key, int val){

        if(NodeMap.get(key)!=null){
        LRUCacheNode node = NodeMap.get(key);
        node.val=val;
        moveToFront(node);
        return;
    }
        LRUCacheNode node = new LRUCacheNode();
        node.key=key;
        node.val=val;

        addToFront(node);
        NodeMap.put(key,node);

        if(presentCapacity>maxCapacity)
            removeTail();
    }

    public void removeTail(){
        NodeMap.remove(tail.pre.key);
        removeFromList(tail.pre);

    }
    public void moveToFront(LRUCacheNode node){
        removeFromList(node);
    //change node next and pre
     node.pre=head;
     node.next=head.next;
     addToFront(node);
    }

    public void removeFromList(LRUCacheNode node){
        //change the node pre and next link
        node.pre.next=node.next;
        node.next.pre=node.pre;
        presentCapacity--;
    }

    public void addToFront(LRUCacheNode node){
        node.pre=head;
        node.next=head.next;
        //change head links
        head.next.pre=node;
        head.next=node;
        presentCapacity++;
    }
}
