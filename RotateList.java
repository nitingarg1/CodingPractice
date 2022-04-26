public class RotateList {
    public static void main(String[] args) {
        ListNode rootNode = new ListNode(1);
        rootNode.next=new ListNode(2);
        rootNode.next.next=new ListNode(3);
        rootNode.next.next.next=new ListNode(4);
        rootNode.next.next.next.next= new ListNode(5);
        new RotateList().rotateRight(rootNode,2);
    }
    public ListNode rotateRight(ListNode head, int k) {
        ListNode dummy = new ListNode();
        dummy.next=head;
        ListNode slow= head;
        ListNode fast = head;
        ListNode last=null;

        //move the fastNode by K places;
        for(int i=0;i<k+1;i++)
            fast=fast.next;
        //move till the end
        while(fast!=null){
            slow=slow.next;
            last=fast;
            fast=fast.next;
        }

        last.next=dummy.next;
        dummy.next=slow.next;
        slow.next=null;
        return dummy.next;
    }
}
