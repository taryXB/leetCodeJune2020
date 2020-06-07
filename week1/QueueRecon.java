/* Queue Reconstruction by Height

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.

 
Example

Input:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

Output:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]
 */

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        int N = people.length;
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b){
                if(a[0]==b[0])
                    return Integer.compare(a[1],b[1]);

                return Integer.compare(a[0],b[0]);
            }
        });
        int[][] res = new int[N][2];
        for(int[] arr: res)
            Arrays.fill(arr, -1);
        for(int i = 0; i < N; i++)
        {
            int count = people[i][1];
            for(int j = 0; j < N; j++)
            {
                if(res[j][0]==-1 && count==0)
                {
                    res[j][0] = people[i][0];
                    res[j][1] = people[i][1];
                    break;
                }
                else if(res[j][0]==-1 || res[j][0]>=people[i][0])
                    count-=1;
            }
        }
        return res;
    }
}

