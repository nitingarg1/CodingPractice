import java.security.Key;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class AllOne {
    Map<String,Node> dataMap;
    Node head,tail;

    public AllOne() {
    dataMap=new HashMap<>();
    head=new Node();
    tail = new Node();
    tail.count=-2;
    }

    public void inc(String key) {
    //check if key exist
        if(!dataMap.containsKey(key)){
            if(head.next==null || head.next.count!=1){
                Node newNode = new Node();
                newNode.count=1;
                insertNewNode(newNode,head);
            }
            head.next.key.add(key);
            dataMap.put(key,head.next);
        }else{
            Node n =dataMap.get(key);
            if(n.next==null || n.next.count!=n.count+1){
                Node newNode = new Node();
                newNode.count=n.count+1;
                insertNewNode(newNode,n);
            }
            n.next.key.add(key);
            n.key.remove(key);
            if(n.key.size()==0)
                removeNode(n);
        }
    }

    public void dec(String key) {
        if(!dataMap.containsKey(key))
            return;
        Node n =dataMap.get(key);
        if(n.count==1){
            n.key.remove(key);
            if(n.key.size()==0)
                removeNode(n);
            return;
        }
        if(n.pre.count==0 || n.pre.count!=n.count-1){
            Node newNode = new Node();
            newNode.count=n.count-1;
            insertNewNode(newNode,n);
        }
        n.next.key.add(key);
        n.key.remove(key);
        if(n.key.size()==0)
            removeNode(n);

    }

    public String getMaxKey() {
    return "";
    }

    public String getMinKey() {
        return "";
    }

    private class Node{
        Set<String> key=new HashSet<>();
        int count=0;
        Node next;
        Node pre;

    }

    private void insertNewNode(Node newNode, Node insertAfter ){
        newNode.next=insertAfter.next;
        newNode.pre=insertAfter;
        insertAfter.next=newNode;
        if(insertAfter.next!=null)
            insertAfter.next.pre=newNode;
    }

    private void removeNode(Node n){
        n.pre.next=n.next;
        if(n.next!=null)
            n.next.pre=n.pre;
    }
}
