/*
Link- https://leetcode.com/problems/maximum-product-subarray/submissions/
*/

//BruteForce approach- 2 loops - O(n^2)
//Best - prefix & suffix O(n)

//Prefix suffix varb maintain,If prefix/suffix=0, whenever encounter 0 set pref & suf=1,at every iteration ans update to max subarr product

public int maximumProductSubarray(int[] nums) 
{
    int ans=Integer.MIN_VALUE;
    int n=nums.length;
    int pref=1;
    int suf=1;
  
    for(int i=0;i<n;i++)
    {
        if(pref==0) 
            pref=1;
        if(suf==0) 
            suf=1;
        pref*=nums[i];
        suf*=nums[n-i-1];
        
        ans=Math.max(ans,Math.max(pref,suf));                        
        
    }
    return ans;
}
