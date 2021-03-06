//There are 2N people a company is planning to interview. The cost of flying the
// i-th person to city A is costs[i][0], and the cost of flying the i-th person to
// city B is costs[i][1]. 
//
// Return the minimum cost to fly every person to a city such that exactly N peo
//ple arrive in each city. 
//
// 
//
// Example 1: 
//
// 
//Input: [[10,20],[30,200],[400,50],[30,20]]
//Output: 110
//Explanation: 
//The first person goes to city A for a cost of 10.
//The second person goes to city A for a cost of 30.
//The third person goes to city B for a cost of 50.
//The fourth person goes to city B for a cost of 20.
//
//The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people inte
//rviewing in each city.
// 
//
// 
//
// Note: 
//
// 
// 1 <= costs.length <= 100 
// It is guaranteed that costs.length is even. 
// 1 <= costs[i][0], costs[i][1] <= 1000 
// Related Topics Greedy


import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int twoCitySchedCost(int[][] costs) {
        List<Cost> list = Stream.of(costs).map(c -> new Cost(c[0], c[1])).collect(Collectors.toList());
        list.sort((c1, c2) -> {
            return Integer.compare(Math.abs(c2.a - c2.b), Math.abs(c1.a - c1.b));
        });
        int half = list.size()/2;
        int a = 0;
        int b = 0;
        int sum = 0;
        for(Cost c : list) {
            if(c.a <= c.b && a < half) {
                sum += c.a;
                a++;
            }
            else if(c.a > c.b && b < half) {
                sum += c.b;
                b++;
            }
            else if(a < half) {
                sum += c.a;
                a++;
            }
            else {
                sum += c.b;
                b++;
            }
        }

        return sum;
    }

    private static class Cost {
        int a;
        int b;

        public Cost(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return "a: "+ a +", b: "+ b;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
