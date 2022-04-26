public class ReverseLinkList {
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next = new ListNode(2);
        n.next.next = new ListNode(3);
        n.next.next.next = new ListNode(4);
        n.next.next.next.next = new ListNode(5);
        new ReverseLinkList().reverseBetween(n,2,4);
//        new ReverseLinkList().reverse(n,5);
    }
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if(head==null || left==right)
            return head;
        ListNode sentinel = new ListNode();
        ListNode pre = sentinel;
        //go the node that need to be revered
        while(left>1){
            pre.next=head;
            pre=pre.next;
            head=head.next;
            left--;right--;
        }
        ListNode preResNode=null;
        ListNode revTail= head;
        //go to the end
        while(right>0){
        ListNode temp = head.next;
        head.next=preResNode;
        preResNode=head;
        head=temp;
        right--;
        }
        revTail.next=head;
        pre.next=preResNode;
        return sentinel.next;
    }

}
