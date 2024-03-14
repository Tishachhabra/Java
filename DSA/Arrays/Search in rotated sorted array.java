/*
Link :- https://leetcode.com/problems/search-in-rotated-sorted-array/submissions/1015116893/
*/

public class Solution 
{
    public int search(int[] nums, int target) 
  {
        int low = 0, high = nums.length - 1;
        while (low <= high)                       //binary search
        {
            int mid = (low + high) / 2;
            if (nums[mid] == target)
                return mid;

          //either mid is in real array or in rotated one
            if (nums[low] <= nums[mid])                                //real array
            {
                if (nums[low] <= target && target <= nums[mid])        //target is in left section section , checking target boundaries
                    high = mid - 1;
                else
                    low = mid + 1;
            } else 
            {
                if (nums[mid] <= target && target <= nums[high])      //in roated 
                    low = mid + 1;
                else
                    high = mid - 1;
            }
        }
        return -1;
    }
}
