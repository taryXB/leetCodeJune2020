/* The set [1,2,3,...,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order, we get the following sequence for n = 3:

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.

Note:

Given n will be between 1 and 9 inclusive.
Given k will be between 1 and n! inclusive.
Example 1:

Input: n = 3, k = 3
Output: "213"
Example 2:

Input: n = 4, k = 9
Output: "2314"
 */

class Solution {
    private ArrayList<Integer> fact, digits;
    public String getPermutation(int n, int k) {
        fact = new ArrayList<>();
        digits = new ArrayList<>();
        fact.add(1);
        for(int i = 1; i <= n; i++) {
            fact.add(i * fact.get(i-1));
        }
        for(int i = 1; i <= n; i++) {
            digits.add(i);
        }
        StringBuilder s = new StringBuilder();
        return solve(n,k,s);
    }
    String solve(int n , int k, StringBuilder s) {
        if(n==1) {
            s.append(digits.get(digits.size() - 1));
            return s.toString();
        }
        int index = k / fact.get(n-1);
        if(k%fact.get(n-1) == 0)
            index--;
        s.append(digits.get(index));
        digits.remove(index);
        k -= fact.get(n-1) * index;
        return solve(n-1, k, s);
    }
}
