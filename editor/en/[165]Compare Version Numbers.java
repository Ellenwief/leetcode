//Compare two version numbers version1 and version2. 
//If version1 > version2 return 1; if version1 < version2 return -1;otherwise re
//turn 0. 
//
// You may assume that the version strings are non-empty and contain only digits
// and the . character. 
// The . character does not represent a decimal point and is used to separate nu
//mber sequences. 
// For instance, 2.5 is not "two and a half" or "half way to version three", it 
//is the fifth second-level revision of the second first-level revision. 
// You may assume the default revision number for each level of a version number
// to be 0. For example, version number 3.4 has a revision number of 3 and 4 for i
//ts first and second level revision number. Its third and fourth level revision n
//umber are both 0. 
//
// 
//
// Example 1: 
// 
//Input: version1 = "0.1", version2 = "1.1"
//Output: -1 
//
// Example 2: 
// 
//Input: version1 = "1.0.1", version2 = "1"
//Output: 1 
//
// Example 3: 
// 
//Input: version1 = "7.5.2.4", version2 = "7.5.3"
//Output: -1 
//
// Example 4: 
// 
//Input: version1 = "1.01", version2 = "1.001"
//Output: 0
//Explanation: Ignoring leading zeroes, both “01” and “001" represent the same n
//umber “1” 
//
// Example 5: 
// 
//Input: version1 = "1.0", version2 = "1.0.0"
//Output: 0
//Explanation: The first version number does not have a third level revision num
//ber, which means its third level revision number is default to "0" 
//
// 
//
// Note: 
// 
// Version strings are composed of numeric strings separated by dots . and this 
//numeric strings may have leading zeroes. 
// Version strings do not start or end with dots, and they will not be two conse
//cutive dots. 
// Related Topics String


import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int compareVersion(String version1, String version2) {
        if(version1 == null && version2 == null) {
            return 0;
        }
        else if(version1 == null) {
            return -1;
        }
        else if(version2 == null) {
            return 1;
        }

        int[] v1 = Stream.of(version1.split("\\.")).map(Integer::parseInt).mapToInt(i -> i).toArray();
        int[] v2 = Stream.of(version2.split("\\.")).map(Integer::parseInt).mapToInt(i -> i).toArray();
        int len = Math.max(v1.length, v2.length);

        int[] ver1 = Arrays.copyOf(v1, len);
        int[] ver2 = Arrays.copyOf(v2, len);

        for(int i = 0; i < len; i++) {
            if(ver1[i] > ver2[i]) {
                return 1;
            }
            else if(ver1[i] < ver2[i]) {
                return -1;
            }
        }
        return 0;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
