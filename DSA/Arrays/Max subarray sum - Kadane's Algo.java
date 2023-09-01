/*
Link - https://leetcode.com/problems/maximum-subarray/
*/

//Kadane algo - maintain max_sum_sofar & cur_sum & - O(n) 
public int maxSubArray(int[] nums) 
{
    int maxSum = Integer.MIN_VALUE;
    int currentSum = 0;
    
    for (int i = 0; i < nums.length; i++) 
    {
        currentSum += nums[i];
        if (currentSum > maxSum) 
        {
            maxSum = currentSum;
        }
        if (currentSum < 0) 
        {
            currentSum = 0;
        }
    }
    return maxSum;
}
