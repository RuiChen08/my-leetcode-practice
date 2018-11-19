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


    //Leetcode problem 21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        boolean v = l1.val < l2.val;
        ListNode sm = v ? l1 : l2, la = v ? l2 : l1;

        while (sm != null && la != null) {
            if (sm.next == null || sm.next.val > la.val) { ListNode temp = sm.next; sm.next = la; la = temp;}
            sm = sm.next;
        }

        return v ? l1 : l2;
//        if (l1.val < l2.val){
//            l1.next = mergeTwoLists(l1.next, l2);
//            return l1;
//        } else{
//            l2.next = mergeTwoLists(l1, l2.next);
//            return l2;
//        }

    }

}
