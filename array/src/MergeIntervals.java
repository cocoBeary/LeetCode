
/***
 * 
 * 56. Merge Intervals
 * 
 * Medium
 * 
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * 
 * Output: [[1,6],[8,10],[15,18]]
 * 
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: [[1,4],[4,5]]
 * 
 * Output: [[1,5]]
 * 
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
	// time O(nlogn) space O(n)
	public List<Interval> merge(List<Interval> intervals) {
		if (intervals == null || intervals.size() <= 1)
			return intervals;
		Collections.sort(intervals, (a, b) -> a.start - b.start);
		int start = intervals.get(0).start;
		int end = intervals.get(0).end;
		List<Interval> res = new ArrayList<>();
		for (Interval interval : intervals) {
			if (interval.start <= end) {
				end = Math.max(end, interval.end);
			} else {
				res.add(new Interval(start, end));
				start = interval.start;
				end = interval.end;
			}
		}
		res.add(new Interval(start, end));
		return res;
	}

	public static void main(String[] args) {
		List<Interval> intervals = new ArrayList<>();
		intervals.add(new Interval(1, 3));
		intervals.add(new Interval(2, 6));
		intervals.add(new Interval(8, 10));
		intervals.add(new Interval(15, 18));
		MergeIntervals test = new MergeIntervals();
		System.out.println(test.merge(intervals));
	}
}
