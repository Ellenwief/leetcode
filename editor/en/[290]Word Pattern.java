//Given a pattern and a string str, find if str follows the same pattern. 
//
// Here follow means a full match, such that there is a bijection between a lett
//er in pattern and a non-empty word in str. 
//
// Example 1: 
//
// 
//Input: pattern = "abba", str = "dog cat cat dog"
//Output: true 
//
// Example 2: 
//
// 
//Input:pattern = "abba", str = "dog cat cat fish"
//Output: false 
//
// Example 3: 
//
// 
//Input: pattern = "aaaa", str = "dog cat cat dog"
//Output: false 
//
// Example 4: 
//
// 
//Input: pattern = "abba", str = "dog dog dog dog"
//Output: false 
//
// Notes: 
//You may assume pattern contains only lowercase letters, and str contains lower
//case letters that may be separated by a single space. 
// Related Topics Hash Table


import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<String, String> pmap = new HashMap<>();
        Map<String, String> kmap = new HashMap<>();
        Scanner scanner = new Scanner(str);

        for(int i = 0; i < pattern.length(); i++) {
            if(!scanner.hasNext()) {
                return false;
            }

            String next = scanner.next();
            String p = pattern.substring(i, i+1);

            if(!kmap.containsKey(next)) {
                kmap.put(next, p);
            }

            if(!pmap.containsKey(p)) {
                pmap.put(p, next);
            }

            String pp = kmap.get(next);
            String val = pmap.get(p);

            if(!(p.equals(pp) && next.equals(val))) {
                return false;
            }
        }

        if(scanner.hasNext()) {
            return false;
        }

        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
