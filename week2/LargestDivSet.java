/* Largest Divisible Subset

Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:

Si % Sj = 0 or Sj % Si = 0.

If there are multiple solutions, return any subset is fine.

Example 1:

Input: [1,2,3]
Output: [1,2] (of course, [1,3] will also be ok)
Example 2:

Input: [1,2,4,8]
Output: [1,2,4,8]
 */

class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int N = nums.length;
        Arrays.sort(nums);
        int[] DP = new int[N];
        int max = 1;
        Arrays.fill(DP, 1);
        for(int i = 1; i < N; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i]%nums[j]==0 && DP[j]+1 > DP[i]){
                    DP[i] = DP[j] + 1;
                }
            }
            max = Math.max(max, DP[i]);
        }
        List<Integer> res = new ArrayList<>();
        for(int i = N-1; i>=0; i--) {
            if(DP[i] == max){
                res.add(nums[i]);
                max--;
            }
        }
        return res;
    }
}

