//variation of knapsack (target as M & arr elements as objects to choose), by recursion/memoization/tabulation dp
//recursion of number taken (include) + notTaken(exclude) in subsequence+ if any true then ans=true , memorization- save ans in dp+check dp before recurring , full tabulation bottom-up approach +dp[ind][M] represent if M can be obtained by 0 to ind elements. dp[n-1][M] =ans

static boolean subsetSumToK(int n, int k, int[] arr) 
{
        boolean dp[][] = new boolean[n][k + 1];
        
        // Initialize the first row of the DP table
        for (int i = 0; i < n; i++) {
            dp[i][0] = true;
        }

        // Initialize the first column of the DP table
        if (arr[0] <= k) {
            dp[0][arr[0]] = true;
        }

        // Fill in the DP table using bottom-up approach
        for (int ind = 1; ind < n; ind++) {
            for (int target = 1; target <= k; target++) {
                // Calculate if the current target can be achieved without taking the current element
                boolean notTaken = dp[ind - 1][target];
                
                // Calculate if the current target can be achieved by taking the current element
                boolean taken = false;
                if (arr[ind] <= target) {
                    taken = dp[ind - 1][target - arr[ind]];
                }
                
                // Store the result in the DP table
                dp[ind][target] = notTaken || taken;
            }
        }
        return dp[n - 1][k];
    }
