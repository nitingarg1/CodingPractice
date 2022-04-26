public class PlusOneLinkedList {
    public static void main(String[] args) {
        ListNode n = new ListNode(9);
        n.next = new ListNode(9);
        n.next.next = new ListNode(9);
        ListNode outPut = new PlusOneLinkedList().plusOne(n);
        System.out.println(outPut);
    }
    public ListNode plusOne(ListNode head) {
        int carry=plusOneRecursion(head);
        if(carry>0){
            ListNode newNode = new ListNode(carry);
            newNode.next=head;
            head=newNode;
        }
        return head;
    }

    public int plusOneRecursion(ListNode head) {
        if(head==null)
            return 1;
        int num= head.val+plusOneRecursion(head.next);
        head.val=num%10;
        return num/10;
    }
}
