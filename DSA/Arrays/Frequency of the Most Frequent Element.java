/*
Link - https://leetcode.com/problems/frequency-of-the-most-frequent-element/description/

O(nlogn) - Sort array , apply sliding window , start from both L & R pointers at 0 index. For each window, test formulae (Aim- to make whole window of Rth pointer number)(Ans- window size): 
current number(R) * range of window > current window total sum + k
if it's true = cannot make whole window of that number , shorten window by updating L by +1 and minus from window total
if its false = can make whole window of that number , this is a potential answer length(max freq ) can expand window size by increasing R

Loop till R<=nums.length
*/

public int maxFrequency(int[] nums, int k) 
{
        Arrays.sort(nums);
        int l=0,r=0,result=0;
        long total=0;
        while(r<nums.length)
        {
            total+=nums[r];
            while(((long)nums[r]*(r-l+1))>total+k)
            {
                total-=nums[l];
                l++;
            }
            result=Math.max(result,r-l+1);
            r++;
        }
        return result;
}
