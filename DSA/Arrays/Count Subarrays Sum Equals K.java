// Same logic as to find whether is a subarray sum = to k

class Solution 
{
    public int subarraySum(int[] nums, int k) 
    {
        int count=0,n=nums.length;
        Map<Long, Integer> map = new HashMap<>();          //store prefi sum and a frequency that how many times this presum has come
        long sum = 0;
        for (int i = 0; i < n; i++) 
        {
            sum += nums[i];
            if (sum == k) count++;          //to increase count if prefix sum till i - required subarray
            long rem = sum - k;              
            if (map.containsKey(rem))       
            { 
                count=count+map.get(rem);      //increase counts by the frequency of presum
            }
            map.put(sum,map.getOrDefault(sum,0)+1);
        }
        return count;
    }
}
