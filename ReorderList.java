public class ReorderList {

    public static void main(String[] args) {
    ListNode n = new ListNode(1);
    n.next = new ListNode(2);
    n.next.next = new ListNode(3);
    n.next.next.next = new ListNode(4);
    new ReorderList().reorderList(n);
    }

    public void reorderList(ListNode head) {
     if(head==null|| head.next==null )
         return ;

     //find the mid of the list
        ListNode pre =null;
        ListNode sentinel = new ListNode();
        sentinel.next=head;
        ListNode slow=head;
        ListNode fast = head;

        while(fast!=null && fast.next!=null){
            pre=slow;
            slow=slow.next;
            fast=fast.next.next;
        }
        //split the list in to 2 parts
        pre.next=null;

        //reverse the second split
        slow=reverse(slow);
        merge(head,slow);
    }

    public ListNode reverse(ListNode head){
        ListNode pre=null;
        while(head!=null){
            ListNode temp = head.next;
            head.next=pre;
            pre=head;
            head=temp;
        }
        return pre;
    }

    public void merge(ListNode first, ListNode second){
        while(first!=null){
            ListNode firstNext = first.next;
            ListNode secondNext = second.next;
            first.next=second;
            if(firstNext==null)
                return ;
            second.next=firstNext;
            first=firstNext;
            second=secondNext;

        }

    }
}
