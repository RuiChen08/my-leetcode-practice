import java.util.*;

public class MergeIntervals {

    public class Interval {
        int start;
        int end;
        Interval() { start = 0; end = 0; }
        Interval(int s, int e) { start = s; end = e;}
    }


    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> ans = new LinkedList<>();
        if (intervals.size() == 0) return ans;

        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                return o1.start - o2.start;
            }
        });

        Interval in1 = intervals.remove(0), in2 = null;
        while (!intervals.isEmpty()) {
            in2 = intervals.remove(0);
            if (in1.end >= in2.start) in1.end = Math.max(in1.end, in2.end);
            else {
                ans.add(in1);
                in1 = in2;
            }
        }
        ans.add(in1);
        return ans;

//        if (intervals.size() == 0) return new LinkedList<>();
//        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> a.start - b.start);
//        pq.addAll(intervals);
//        intervals.clear();
//
//        Interval in1 = pq.peek();
//        while (!pq.isEmpty()){
//            Interval in2 = pq.peek();
//            if (in1.end >= in2.start) in1 = new Interval(Math.min(in1.start, in2.start), Math.max(in1.end, in2.end));
//            else {
//                intervals.add(in1);
//                in1 = in2;
//            }
//        }
//        intervals.add(in1);
//        return intervals;
    }
}
