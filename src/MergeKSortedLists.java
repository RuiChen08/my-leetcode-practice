import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class MergeKSortedLists {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists == null || lists.length == 0) return null;
//
//        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
//            @Override
//            public int compare(ListNode o1, ListNode o2) {
//                return o1.val - o2.val;
//            }
//        });
//
//        ListNode fakeStart = new ListNode(0);
//        ListNode dd = fakeStart;
//
//        for (ListNode ln : lists)
//            if (lists != null)
//                queue.add(ln);
//
//        while (!queue.isEmpty()){
//            dd.next = queue.poll();
//            dd = dd.next;
//
//            if (dd.next != null)
//                queue.add(dd.next);
//        }
//
//        return fakeStart.next;
//    }

    //Divided and conquer method
    public ListNode mergeKLists(ListNode[] lists) {
        return mergeKListsHelper(lists, 0, lists.length);
    }

    public ListNode mergeKListsHelper(ListNode[] lists, int start, int end){
        if (end == start || lists == null) return null;
        else if (end - start == 1) return lists[start];
        else if (end - start == 2) return mergeTwoLists(lists[start], lists[start+1]);
        else return mergeTwoLists(mergeKListsHelper(lists, start, start + (end - start) / 2), mergeKListsHelper(lists, start + (end - start) / 2, end));
    }


    //Leetcode problem 21
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;
        if (l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    //Leetcode problem 24
    /*
     *Given a linked list, swap every two adjacent nodes and return its head.
     *
     *Example:
     *
     *Given 1->2->3->4, you should return the list as 2->1->4->3.
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode pre = head;
        ListNode mid = pre.next;
        ListNode nex = mid.next;

        mid.next = pre;
        pre.next = swapPairs(nex);

        return mid;
    }

}

