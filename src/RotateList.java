public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0) return head;
        ListNode end = head, cur = head;
        int len = 1;
        while (end.next != null){
            if (len > k) cur = cur.next;
            end = end.next;
            len++;
        }

        if (len <= k){
            return rotateRight(head, k % len);
        }
        end.next = head;
        head = cur.next;
        cur.next = null;

        return head;
    }

}
