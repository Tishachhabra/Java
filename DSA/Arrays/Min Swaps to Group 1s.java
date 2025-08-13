//Link - https://www.geeksforgeeks.org/problems/minimum-swaps-required-to-group-all-1s-together2451/1
// Best - O(n) - Sliding of window size = no. of ones in arr to see how many minZeroes are there in a window = min swap required in that window

import java.util.* ;
import java.io.*; 
public class Solution 
{
    public static int groupAllOneTogether(int arr[], int n) 
    {
        int ones=0;
        for(int digit:arr)
        {
            if(digit==1)
            ones++;
        }
        if(ones==1 || ones==n)            //1s already grouped together
        return 0;
        else if(ones==0)                  // no 1 available
        return -1;

        int count=0;
        for(int i=0;i<ones;i++)            //initialise count of zeroes = first window zeroes
        {
            if(arr[i]==0)
            count++;
        }
        int minZeroes=count;              //for initialising only take first count
        for(int r=ones;r<n;r++)            // slide through 2nd window of 'ones' size  - add rightmost ele ; remove leftmost
        {
            if(arr[r]==0) count++;
            if(arr[r-ones]==0) count--;
            minZeroes=Math.min(minZeroes,count);    //compare
        }
        return minZeroes;
    }
}
