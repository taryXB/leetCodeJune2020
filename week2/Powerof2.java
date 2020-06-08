/* Power of Two
Given an integer, write a function to determine if it is a power of two.

Example 1:

Input: 1
Output: true 
Explanation: 20 = 1
Example 2:

Input: 16
Output: true
Explanation: 24 = 16
Example 3:

Input: 218
Output: false
 */

class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n<1) return false;
        int count = 0;
        for(int i = 1; i <= 32; i++) {
            if(count > 1) return false;
            if((n&1)==1) count++;
            n = n >> 1;
        }
        return true;
    }
}

