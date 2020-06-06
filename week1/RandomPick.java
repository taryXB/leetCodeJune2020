/* Random Pick with Weight
Given an array w of positive integers, where w[i] describes the weight of index i, write a function pickIndex which randomly picks an index in proportion to its weight.

Note:

1 <= w.length <= 10000
1 <= w[i] <= 10^5
pickIndex will be called at most 10000 times.
Example 1:

Input: 
["Solution","pickIndex"]
[[[1]],[]]
Output: [null,0]
Example 2:

Input: 
["Solution","pickIndex","pickIndex","pickIndex","pickIndex","pickIndex"]
[[[1,3]],[],[],[],[],[]]
Output: [null,0,1,1,1,0]
Explanation of Input Syntax:

The input is two lists: the subroutines called and their arguments. Solution's constructor has one argument, the array w. pickIndex has no arguments. Arguments are always wrapped with a list, even if there aren't any.
*/

class Solution {
    int[] weights;
    int sum;
    public Solution(int[] w) {
        weights = new int[w.length];
        sum = 0;
        for(int i = 0; i < w.length; ++i) {
            sum += w[i];
            weights[i] = sum;
        }
    }

    public int pickIndex() {
        int r = (int)(Math.random() * sum);
        return binarySearch(1 + r);
    }

    private int binarySearch(int x){
        int l = 0;
        int h = weights.length-1;
        while(l < h) {
            int mid = l + (h-l)/2;
            if( x > weights[mid])
                l = mid + 1;
            else
                h = mid;
        }
        return l;
    }
}

/*
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
