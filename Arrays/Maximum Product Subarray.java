/*
Link- https://leetcode.com/problems/maximum-product-subarray/submissions/

Cases:-
1) All nos. positive = whole array is ans
2) Even number of negatives= whole array
3) Odd number of negatives=either pref or suf is ans
4) Array contains 0=prefix/suffix, whenever encounter 0 set pref & suf=1
*/

//BruteForce approach- 2 loops - O(n^2)
//Best - prefix & suffix by taking all above 3 cases - O(n)

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
        
        ans=Math.max(ans,Math.max(pref,suf));                        //import java.math.*
    }
    return ans;
}
