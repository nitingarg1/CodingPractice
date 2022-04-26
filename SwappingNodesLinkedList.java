public class SwappingNodesLinkedList {
    public ListNode swapNodes(ListNode head, int k) {
        ListNode start= head;
        ListNode secondStart=head;
        ListNode kthFromStart=null;
        int count=0;
        while(count<k){
            kthFromStart=start;
            start=start.next;
        }
        while(start!=null){
            secondStart=secondStart.next;
            start=start.next;
        }
        int tempVal=kthFromStart.val;
        kthFromStart.val= secondStart.val;
        secondStart.val=tempVal;
        return head;
    }
}
