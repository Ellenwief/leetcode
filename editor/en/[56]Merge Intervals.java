//Given a collection of intervals, merge all overlapping intervals. 
//
// Example 1: 
//
// 
//Input: [[1,3],[2,6],[8,10],[15,18]]
//Output: [[1,6],[8,10],[15,18]]
//Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// 
//
// Example 2: 
//
// 
//Input: [[1,4],[4,5]]
//Output: [[1,5]]
//Explanation: Intervals [1,4] and [4,5] are considered overlapping. 
//
// NOTE: input types have been changed on April 15, 2019. Please reset to defaul
//t code definition to get new method signature. 
// Related Topics Array Sort


import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> {
            int cmp = Integer.compare(o1[0], o2[0]);
            if(cmp == 0) {
                return Integer.compare(o1[1], o2[1]);
            }
            return cmp;
        });
        int[] prev = null;
        for(int[] i : intervals) {
            if(prev == null) {
                prev = new int[]{i[0], i[1]};
            }
            else if(isInRange(i, prev) || isInRange(prev, i)) {
                prev[0] = Math.min(i[0], prev[0]);
                prev[1] = Math.max(i[1], prev[1]);
            }
            else if(prev != null){
                list.add(prev);
                prev = new int[]{i[0], i[1]};
            }
        }

        if(prev != null) {
            list.add(prev);
        }

        int[][] newIntervals = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            newIntervals[i] = list.get(i);
        }
        return newIntervals;
    }

    private boolean isInRange(int[] i, int[] j) {
        return (i[0] <= j[0] || i[0] >= j[0]) &&
                i[0] <= j[1] &&
                (i[1] >= j[0] && i[1] <= j[1] || i[1] >= j[1]);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
