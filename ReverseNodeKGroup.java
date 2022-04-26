public class ReverseNodeKGroup {
    public static void main(String[] args) {
    ListNode start = new ListNode(1);
    start.next=new ListNode(2);
    start.next.next=new ListNode(3);
    start.next.next.next=new ListNode(4);
    start.next.next.next.next=new ListNode(5);
    new ReverseNodeKGroup().reverseKGroup(start,2);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode[] temp = new ListNode[k];
        int count=0;
        while(count<k){
            temp[count]=head;
            if(head==null)
                return start;
            head=head.next;
            count++;
        }
        ListNode pre=null;
        for(ListNode node:temp){
            node.next=pre;
            pre=node;
        }
        temp[0]=reverseKGroup(head,k);
        return temp[k-1];

    }
}
