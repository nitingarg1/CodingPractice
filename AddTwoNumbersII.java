public class AddTwoNumbersII {
    public static void main(String[] args) {
        ListNode n = new ListNode(7);
        n.next = new ListNode(2);
        n.next.next = new ListNode(4);
        n.next.next.next = new ListNode(3);

        ListNode n2 = new ListNode(5);
        n2.next = new ListNode(6);
        n2.next.next = new ListNode(4);

        new AddTwoNumbersII().addTwoNumbers(n,n2);
    }
   public ListNode addTwoNumbers(ListNode l1 , ListNode l2){
        l1=reverseList(l1);
        l2=reverseList(l2);
        int carry=0;
        ListNode pre=null;
        ListNode start=null;
        while(l1!=null || l2!=null){
            ListNode temp1 = l1;
            l1=l1==null ? l1 :l1.next;
            ListNode temp2 = l2;
            l2=l2==null ? l2:l2.next;
            int sum = carry+(temp1==null?0:temp1.val)+(temp2==null?0:temp2.val);
            ListNode node = new ListNode(sum%10);
            node.next=pre;
            pre=node;
            carry=sum/10;
       }
        if(carry>0){
            ListNode node = new ListNode(carry);
            node.next=pre;
            pre=node;
        }
        return pre;
   }

   public ListNode reverseList(ListNode l1){
        ListNode pre=null;
        while(l1!=null){
            ListNode temp =l1;
            l1=l1.next;
            temp.next=pre;
            pre=temp;
        }
        return pre;
   }
}
