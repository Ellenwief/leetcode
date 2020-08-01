//Count the number of prime numbers less than a non-negative number, n. 
//
// Example: 
//
// 
//Input: 10
//Output: 4
//Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
// 
// Related Topics Hash Table Math 
// 👍 2066 👎 620

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int countPrimes(int n) {
        List<Integer> primes = new ArrayList<>();

        for(int i = 2; i <= 3 && i < n; i++) {
            primes.add(i);
        }

        for(int i = 5; i < n; i += 2) {
            if(this.isPrime(primes, i)) {
                primes.add(i);
            }
        }

        return primes.size();
    }

    private boolean isPrime(List<Integer> primes, int num) {
        for(Integer p : primes) {
            if(p * p > num) {
                break;
            }
            if(num % p == 0) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
