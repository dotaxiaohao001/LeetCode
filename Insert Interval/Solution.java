/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        if(intervals==null||newInterval==null) {
            return intervals;
        }
        
        if(intervals.size()==0) {
            intervals.add(newInterval);
            return intervals;
        }
        
        ListIterator<Interval> litr = intervals.listIterator();
        while(litr.hasNext()) {
            Interval curInterval = litr.next();
            if(newInterval.end < curInterval.start) { // find the inserted position should insert before current position
                litr.previous();
                litr.add(newInterval); // add at position between previous() and next();
                return intervals;
            } else {
                if(curInterval.end < newInterval.start) { // at behind of current.
                    continue;
                } else { // overlapped case
                    newInterval.start = Math.min(curInterval.start, newInterval.start);
                    newInterval.end   = Math.max(curInterval.end, newInterval.end);
                    litr.remove(); // remove the element of last next. that's to say it is the curInterval. so litr.next() also right 
                }
            }
        }
        intervals.add(newInterval);
        return intervals;
    }
}