import java.util.Comparator;
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

    public ListNode mergeKLists(ListNode[] lists) {

        

        return null;
    }


}

