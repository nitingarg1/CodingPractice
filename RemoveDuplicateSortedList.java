public class RemoveDuplicateSortedList {
    public static void main(String[] args) {
        ListNode n = new ListNode(1);
        n.next=new ListNode(2);
        n.next.next=new ListNode(3);
        n.next.next.next=new ListNode(3);
        n.next.next.next.next=new ListNode(4);
        n.next.next.next.next.next=new ListNode(4);
        n.next.next.next.next.next.next=new ListNode(5);
        new RemoveDuplicateSortedList().deleteDuplicates(n);
    }
    public ListNode deleteDuplicates(ListNode head) {
    ListNode sentinel = new ListNode();
    sentinel.next=head;
    ListNode pre = sentinel;
    while(head!=null){
        if(head.next!=null && head.val==head.next.val){
            while(head.next!=null && head.val==head.next.val)
                head=head.next;
            pre.next=head.next;
        }else{
            pre=pre.next;
        }
        head=head.next;
    }

    return sentinel.next;
    }
}
