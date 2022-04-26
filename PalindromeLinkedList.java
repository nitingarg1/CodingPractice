public class PalindromeLinkedList {
    ListNode start;
    ListNode mover;
    public boolean isPalindrome(ListNode head) {
    start=head;
    mover=head;
    return isPalindromeRec(head);
    }

    public boolean isPalindromeRec(ListNode head) {
        if(head==null)
            return true;
        boolean isPalindrome = isPalindromeRec(head.next) && (head.val==start.val);
        start=start.next;
        return isPalindrome;
    }
}
