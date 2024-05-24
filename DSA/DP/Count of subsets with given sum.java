/*
Link - https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/

Variation of knapsack.
Naive approach-form all subsequences - O(2^n)

Better- by recursion tree(top to bottom) -two choices at every index : 
1) left branch exclusion of that particular arr[index] from subsequence.           
2) right branch inclusion of that arr[index] in subsequence      

Best - using tabulation dp(bottom to top) dp rows (0 based indexing of arr) :index traversing arr. every row will consider elemnts from arr[0] to arr[i]. , dp cols (0 to given sum k): target to achieve
dp [i][c] : represent number of subsequences that can be formed from arr[0] to arr[i] elemnts giving sum c.

First col will be 1 since 0 sum (column) can be achieved anywhere. then by loops : if arr[i]>c then dp[i][c]=0 otherwise dp[i -1][c]+dp[i - 1][c - arr[i] (exclusion+inclusion). (inclusion by taking that number so sum c will be reduced to a previously visited subprblm)

*/


class TUF 
{
    static int findWays(int[] arr, int k) 
  {
        int n = arr.length;
        int[][] dp = new int[n][k + 1];

        // Initialize the first col of DP=1 (sum is 0)
        for (int i = 0; i < n; i++) 
        {
            dp[i][0] = 1;
        }

        // Initialize the first row of the DP
        if (arr[0] <= k) 
        {
            dp[0][arr[0]] = 1;
        }

        // Fill in the DP array using bottom-up dynamic programming
        for (int i = 1; i < n; i++) 
        {
            for (int target = 1; target <= k; target++) 
            {
                // exclusion-Calculate the number of ways when the current element is not taken
                int notTaken = dp[i - 1][target];

                // inclusion-Calculate the number of ways when the current element is taken
                int taken = 0;                          //if ele is greater than target, no needd to compute
                if (arr[i] <= target) 
                {
                    taken = dp[i - 1][target - arr[i]];
                }
                dp[i][target] = notTaken + taken;
            }
        }

        // The result is stored in the last cell of the DP array
        return dp[n - 1][k];
    }

    public static void main(String args[]) {
        int arr[] = {1, 2, 2, 3};
        int k = 3;

        System.out.println("The number of subsets found are " + findWays(arr, k));
    }
}

