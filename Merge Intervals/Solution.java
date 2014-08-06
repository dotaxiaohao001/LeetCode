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
    public ArrayList<Interval> merge(ArrayList<Interval> intervals) {
        if(intervals == null)
        	return null;
        if(intervals.size() == 1)
        	return intervals;

        ArrayList<Interval> result = new ArrayList<Interval>(); // don't miss the parenthesis

        for(Interval newInterval: intervals){
        	insert(result, newInterval);
        }
        return result;
    }

    private ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
    	if(intervals == null || newInterval == null)
    		return intervals;
    	if(intervals.size() == 0) {
    		intervals.add(newInterval);
    		return intervals;
    	}

    	ListIterator<Interval> litr = intervals.listIterator();

    	while(litr.hasNext()) {
    		Interval cur = litr.next();
    		if(newInterval.end < cur.start) {
    			litr.previous();
    			litr.add(newInterval);
    			return intervals;
    		}
    		else if(newInterval.start > cur.end) {
    			continue;
    		}
    		else { // should merge
    			newInterval.start = Math.min(newInterval.start, cur.start);
    			newInterval.end = Math.max(newInterval.end, cur.end);
    			litr.remove();
    		}
    	}
    	intervals.add(newInterval); // insert at the end
    	return intervals;
    }
}