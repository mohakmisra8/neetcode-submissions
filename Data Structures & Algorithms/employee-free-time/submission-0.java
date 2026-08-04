/*
// Definition for an Interval.
class Interval {
    public int start;
    public int end;

    public Interval() {}

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
*/

class Solution {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        // add all schedules to an array and then
        List<Interval> all = new ArrayList<>();
        for (List<Interval> interval : schedule) {
            all.addAll(interval);
        }

        all.sort((a, b) -> a.start - b.start);

        List<Interval> res = new ArrayList<>();
        int previousEnd = all.get(0).end;
        for (int i = 1; i < all.size(); i++) {
            Interval curr = all.get(i);
            if (previousEnd < curr.start) {
                res.add(new Interval(previousEnd, curr.start));
            }
            previousEnd = Math.max(curr.end, previousEnd);
        }

        return res;
    }
}
