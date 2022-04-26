public class InsertCircularLinkList {
    public static void main(String[] args) {
    Node n = new Node(1);
    n.next = new Node(5);
    n.next.next = new Node(9);
    n.next.next.next =n;
    new InsertCircularLinkList().insertInList(n,new Node(0));
    }

    public void insertInList(Node head, Node newNode){
        int nextVal=head.val>newNode.val?Integer.MAX_VALUE:newNode.val;
        Node pre = head;
        Node dummy = new Node();
        dummy.next=head;

        while(head.next!=dummy.next){
            if(head.val>nextVal)
                break;
            pre=head;
            head=head.next;
        }

        pre.next=newNode;
        newNode.next=head;
        return;
    }
}
