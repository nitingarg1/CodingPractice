public class PartitionList {
    public static void main(String[] args) {

    }
    public ListNode partition(ListNode head, int x) {
    ListNode before = new ListNode();
    ListNode beforeStart = before;
    ListNode after = new ListNode();
    ListNode afterStart = after;
    while(head!=null){
        if(head.val<x){
            before.next=head;
            before=before.next;
        }else{
            after.next=head;
            after=after.next;
        }
        head=head.next;
    }
    after.next=null;
    before.next=afterStart.next;
    return beforeStart.next;
    }
}
