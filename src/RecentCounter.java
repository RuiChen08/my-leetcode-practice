import java.util.LinkedList;

class RecentCounter {

    public static void main(String[] args) {
        RecentCounter recentCounter = new RecentCounter();
        System.out.println(recentCounter.ping(0));
        System.out.println(recentCounter.ping(1));
        System.out.println(recentCounter.ping(100));
        System.out.println(recentCounter.ping(3001));
        System.out.println(recentCounter.ping(3002));
    }

    LinkedList<Integer> pings;

    public RecentCounter() {
        pings = new LinkedList<>();
    }

    public int ping(int t) {
        while (pings.size() > 0 && pings.get(0) < t - 3000) pings.pollFirst();
        pings.add(t);
        return pings.size();
    }
}