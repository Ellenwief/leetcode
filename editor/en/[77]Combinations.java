//Given two integers n and k, return all possible combinations of k numbers out 
//of 1 ... n. 
//
// Example: 
//
// 
//Input: n = 4, k = 2
//Output:
//[
//  [2,4],
//  [3,4],
//  [2,3],
//  [1,2],
//  [1,3],
//  [1,4],
//]
// 
// Related Topics Backtracking


import java.lang.reflect.Array;
import java.util.ArrayList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> list = new ArrayList<>();
        for(int i = 1; i <= n; i++) {
            this.findAll(i, n, k, new ArrayList<>(), list);
        }
        return list;
    }

    private void findAll(int start, int last, int len, List<Integer> l, List<List<Integer>> list) {
        if(l.size() == len && !list.contains(l)) {
            list.add(new ArrayList<>(l));
        }

        for(int i = start; i <= last; i++) {
            l.add(i);
            this.findAll(i+1, last, len, l, list);

            // backtrack
            l.remove(l.size() - 1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
