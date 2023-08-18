/*
Link-https://www.interviewbit.com/problems/repeat-and-missing-number-array/
Corner cases - nums is [0,2] | ans=1 , nums is [1,2] | ans=0
*/

// Best :- Sum - O(n)
public int missingNumber(int[] nums) 
{
    int len = nums.length;
    int sum = (0+len)*(len+1)/2;
    for(int i=0; i<len; i++)
    {
        sum-=nums[i];
    }
    return sum;
}

//Binary Search - O(nlogn)+O(n)
public int missingNumber(int[] nums) 
{ 
    Arrays.sort(nums);
    int left = 0, right = nums.length, mid= (left + right)/2;
    while(left<right)
    {
        mid = (left + right)/2;
        if(nums[mid]>mid) right = mid;
        else left = mid+1;
    }
    return left;
}

//Naive - O(nlogn)+O(n)
public int missingNumber(int[] nums) 
{
    if(nums.length==1)
    {
        if(nums[0]!=0)
          return 0;
        else
          return 1;
    }
    Arrays.sort(nums);
    for(int i=1;i<nums.length;i++)
    {
        if(nums[i]-nums[i-1]==2)
        {
            return nums[i]-1;
        }
    }
    if(nums[0]!=0)
        return 0;
    else
        return nums.length;
}

