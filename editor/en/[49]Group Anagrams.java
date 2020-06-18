//Given an array of strings, group anagrams together. 
//
// Example: 
//
// 
//Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
//Output:
//[
//  ["ate","eat","tea"],
//  ["nat","tan"],
//  ["bat"]
//] 
//
// Note: 
//
// 
// All inputs will be in lowercase. 
// The order of your output does not matter. 
// 
// Related Topics Hash Table String


import java.util.ArrayList;
import java.util.Arrays;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<String> anaList = new ArrayList<>();
        List<List<String>> list = new ArrayList<>();
        for(String str : strs) {
            String ana = this.sortedAnaString(str);
            if(!anaList.contains(ana)) {
                List<String> l = new ArrayList<>();
                l.add(str);
                list.add(l);
                anaList.add(ana);
            }
            else {
                int i = anaList.indexOf(ana);
                list.get(i).add(str);
            }
        }
        return list;
    }

    private String sortedAnaString(String str) {
        char[] chars = new char[str.length()];
        for(int i = 0; i < str.length(); i++) {
            chars[i] = str.charAt(i);
        }
        Arrays.sort(chars);
        return new String(chars);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
