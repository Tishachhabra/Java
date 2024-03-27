/*
Link - https://leetcode.com/problems/subarray-product-less-than-k/description/?envType=daily-question&envId=2024-03-27

Bruteforce approach - O(n^2) --Check all subarrays by 2 loops
Best Approach - O(n) -- sliding window (acquire-release) 

if number itself>k + initialise prod nd continue to next element (window restart)
if number<k then mult to prod+ check<k then count+=1+(end-start) -- This formulae containes single length subarrays too

*/



public int numSubarrayProductLessThanK(int[] nums, int k) 
  {
      //corner cases--since nums elements are always >=1
      if(k==0 || k==1)              
      return 0;                        
      
      int cnt=0;
      int prod=1;
      int start=0,end=0;                //borders of sliding window
      for(;end<nums.length;end++)
      {
          if(nums[end]>=k)             //if no. itself>k strt from next as new window
          {
              start=end+1;
              prod=1;
          }
          else
          {
              prod*=nums[end];
              if(prod<k)
              {
                  cnt+=1+(end-start);
              }
              else                    //if prod becomes >k then start releasing (adjust left border of window)
              {
                  while(prod>=k)
                  {
                      prod/=nums[start];
                      start++;
                  }
                  cnt+=1+(end-start);
              }
          }
      }
  return cnt;
  }
