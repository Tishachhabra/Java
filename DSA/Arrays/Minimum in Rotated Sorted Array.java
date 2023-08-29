/*
LINK :- https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/

Goal- To find breaking point / minimum element
*/

//Best Approach- Binary search - O(log n)
public int findMin(int[] arr) 
{
    if(arr.length==1)                               //Base Case of 1 element array
        return arr[0];
    if(arr[arr.length-1]>arr[0])                    //Array already in ascending order
        return arr[0];
    
    int left=0;
    int right=arr.length-1;
    int mid;
    
    while(left<=right)                        
    {
        mid=(left+right)/2;
        if(mid==0)
            return Math.min(arr[0],arr[1]);
      
        if(arr[mid]<arr[mid-1])                      //Breaking point/ans index
            return arr[mid];
        if(arr[0]>arr[mid])                          //ans is in left susbset
            right=mid-1;
        else
            left=mid+1;                              //ans is in right susbset
    }
    return 0;
}
