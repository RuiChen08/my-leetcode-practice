import java.util.List;

public class RemoveNthNode {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        l.next = new ListNode(2);
        l.next.next = new ListNode(3);

        RemoveNthNode r = new RemoveNthNode();
        ListNode head = r.removeNthFromEnd(l, 3);
        System.out.println(head.val);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode slow = head, fast = head;

        for (int i = 0; i < n; i++) {
            if (fast.next == null) return head.next;
            fast = fast.next;
        }

        while (fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;

        return head;
    }

}
