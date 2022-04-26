public class RemoveNthFromEnd {
    public static  class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

    public static void main(String[] args) {
        ListNode input = new RemoveNthFromEnd.ListNode(1);
//        input.next = new RemoveNthFromEnd.ListNode(2);
//        input.next.next= new RemoveNthFromEnd.ListNode(3);
//        input.next.next.next= new RemoveNthFromEnd.ListNode(4);
//        input.next.next.next.next= new RemoveNthFromEnd.ListNode(5);
        System.out.println(removeNthFromEnd1(input,1));
        System.out.println(removeNthFromEnd2(input,1));
    }

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next=head;
        ListNode fast= dummy;
        ListNode slow= dummy;
        for(int i =0 ; i <n; i++){
            fast=fast.next;
        }
        while(fast.next!=null){
            fast=fast.next;
            slow=slow.next;
        }
        slow.next=slow.next.next;
        return dummy.next;
    }

    public static ListNode removeNthFromEnd2(ListNode head, int n){
        ListNode dummy = new ListNode();
        dummy.next=head;
        //define 2 pointers
        ListNode slow=dummy,fast=dummy;
        //move fast to the nth node
        for(int i=0;i<n;i++)
            fast=fast.next;
        //now move both slow and fast till end of list
        while(fast.next!=null){
            slow=slow.next;
            fast=fast.next;
        }
        //remove the node;
        slow.next=slow.next.next;
        return dummy.next;
    }


}
