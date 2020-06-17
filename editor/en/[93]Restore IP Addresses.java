//Given a string containing only digits, restore it by returning all possible va
//lid IP address combinations. 
//
// A valid IP address consists of exactly four integers (each integer is between
// 0 and 255) separated by single points. 
//
// Example: 
//
// 
//Input: "25525511135"
//Output: ["255.255.11.135", "255.255.111.35"]
// 
// Related Topics String Backtracking


import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<List<Integer>> lens = new ArrayList<>();
        List<String> ips = new ArrayList<>();
        int len = s.length();
        int num = 1;
        findAll(lens, 1, len, num, num); num++;
        findAll(lens, 1, len, num, num); num++;
        findAll(lens, 1, len, num, num);

        for(List<Integer> list : lens) {
            String ip = "";
            int sum = 0;
            for(Integer l : list) {
                int ipnum = Integer.valueOf(s.substring(sum, sum+l));
                if(ipnum > 255) break;
                if(ip.length() > 0) ip += ".";
                ip += ipnum;
                sum += l;
            }
            if(sum == len && ip.length() == len + 3) {
                ips.add(ip);
            }
        }

        return ips;
    }

    private void findAll(List<List<Integer>> lens, int depth, int target, int sum, Integer ...nums) {
        if(sum > target) return;
        if(depth == 4) {
            if(target == sum) {
                lens.add(Arrays.asList(nums));
            }
        }
        else {
            for(int i = 1; i <= 3; i++) {
                Integer[] newNums = Arrays.copyOf(nums, nums.length+1);
                newNums[nums.length] = i;
                findAll(lens, depth+1, target, sum+i, newNums);
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
