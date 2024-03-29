/*
Link -https://leetcode.com/problems/count-subarrays-where-max-element-appears-at-least-k-times/description/?envType=daily-question&envId=2024-03-29

// sliding window approach - O(n)
//maintain max freq in window , whenever it reaches k , shrink window size by adjusting left border,add start index to ans(ab tak k saare from left can make valid subarray till i

*/
public int max(int[]nums)                      //to get max element of arr
{
    int max=Integer.MIN_VALUE;
    for(int i=0;i<nums.length;i++)
    {
        max=Math.max(max,nums[i]);
    }
    return max;
}
  public long countSubarrays(int[] nums, int k)         
{   
    int max = max(nums);
    long ans = 0;
    int start = 0, maxfreqinWindow = 0;

    for (int end = 0; end < nums.length; end++) 
    {
        if (nums[end] == max) 
        {
            maxfreqinWindow++;
        }
        while (k == maxfreqinWindow) 
        {
            if (nums[start] == max) 
            {
                maxfreqinWindow--;
            }
            start++;
        }
        ans += start;
    }

    return ans;
}
