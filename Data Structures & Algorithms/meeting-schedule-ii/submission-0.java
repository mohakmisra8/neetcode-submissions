/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        List<int[]> events = new ArrayList<>();
        // build events: +1 start and -=1 for each end
        for(Interval interval: intervals) {
            events.add(new int[]{interval.start, 1}); //start
            events.add(new int[]{interval.end,-1});
        }

        // sort by positon; tie break decided touching behaviour
        // ends (-1) before starts (+1) at equal position → touching meetings reuse a room
        events.sort((a, b) -> a[0] != b[0] ? a[0] - b[0] : a[1] - b[1]);

        int count = 0;
        int peak = 0;
        int start = 0;
        for(int[] e: events) {
            count+= e[1]; // update count
            peak = Math.max(peak, count);
        }

        return peak;

    }
}
