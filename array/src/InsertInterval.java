import java.util.ArrayList;
import java.util.List;

/***
 * 57. Insert Interval Hard
 * 
 * Given a set of non-overlapping intervals, insert a new interval into the
 * intervals (merge if necessary).
 * 
 * You may assume that the intervals were initially sorted according to their
 * start times.
 * 
 * Example 1:
 * 
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * 
 * Output: [[1,5],[6,9]]
 * 
 * Example 2:
 * 
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * 
 * Output: [[1,2],[3,10],[12,16]]
 * 
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 *
 */

public class InsertInterval {
	// time O(n) space O(n)
	public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
		if (newInterval == null)
			return intervals;
		int i = 0;
		List<Interval> newIntervals = new ArrayList<>();
		while (i < intervals.size() && intervals.get(i).end < newInterval.start) {
			newIntervals.add(intervals.get(i++));
		}
		while (i < intervals.size() && intervals.get(i).start <= newInterval.end) {
			newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
			newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
			i++;
		}
		newIntervals.add(newInterval);
		while (i < intervals.size()) {
			newIntervals.add(intervals.get(i++));
		}
		return newIntervals;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(6, 9));
		InsertInterval test = new InsertInterval();
		System.out.println(test.insert(intervals, new Interval(2, 5)));
	}
}
