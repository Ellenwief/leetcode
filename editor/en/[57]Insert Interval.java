//Given a set of non-overlapping intervals, insert a new interval into the inter
//vals (merge if necessary). 
//
// You may assume that the intervals were initially sorted according to their st
//art times. 
//
// 
// Example 1: 
//
// 
//Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//Output: [[1,5],[6,9]]
// 
//
// Example 2: 
//
// 
//Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//Output: [[1,2],[3,10],[12,16]]
//Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10]. 
//
//
// Example 3: 
//
// 
//Input: intervals = [], newInterval = [5,7]
//Output: [[5,7]]
// 
//
// Example 4: 
//
// 
//Input: intervals = [[1,5]], newInterval = [2,3]
//Output: [[1,5]]
// 
//
// Example 5: 
//
// 
//Input: intervals = [[1,5]], newInterval = [2,7]
//Output: [[1,7]]
// 
//
// 
// Constraints: 
//
// 
// 0 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= intervals[i][0] <= intervals[i][1] <= 105 
// intervals is sorted by intervals[i][0] in ascending order. 
// newInterval.length == 2 
// 0 <= newInterval[0] <= newInterval[1] <= 105 
// 
// Related Topics Array Sort 
// 👍 2375 👎 227


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
	public int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals == null || intervals.length == 0) {
			return new int[][]{newInterval};
		}

		List<int[]> list = new ArrayList<>();
		for(int[] interval : intervals) {
			if(this.isInRange(interval, newInterval)) {
				newInterval[0] = Math.min(interval[0], newInterval[0]);
				newInterval[1] = Math.max(interval[1], newInterval[1]);
				continue;
			}
			list.add(interval);
		}

		list.add(newInterval);

		return list.stream()
				.sorted(Comparator.comparingInt(o -> o[0]))
				.toArray(int[][]::new);
	}

	private boolean isInRange(int[] interval1, int[] interval2) {
		if(interval1[0] <= interval2[0]) {
			return interval1[1] >= interval2[0];
		}
		return interval2[1] >= interval1[0];
	}
}
//leetcode submit region end(Prohibit modification and deletion)
