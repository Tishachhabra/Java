/*
Link- https://leetcode.com/problems/trapping-rain-water/submissions/1032574635/
*/

//To keep track of left and right bigger buildings for support at evey index, maintain left and right arrays. Traverse array updating ans. - O(n)
public int trap(int[] arr) 
{
    int n=arr.length;
    if (n == 0  || n==1 || n==2) 
    {
        return 0;
    }
    int []left=new int[n];
    int []right=new int[n];

    left[0]=arr[0];
    for(int i=1;i<n;i++)                                              //array storing height of left biggest building
    {
        left[i]=Math.max(left[i-1],arr[i]);
    }
    right[n-1]=arr[n-1];
    for(int i=n-2;i>=0;i--)                                           //array storing height of right biggest building
    {
        right[i]=Math.max(right[i+1],arr[i]);
    }

    int ans=0;
    for(int i=0;i<n;i++)
    {
        ans+=Math.min(left[i],right[i])-arr[i];                        //at every index water cn be filled until smallest building betwen left/ri8
    }
    return ans;
}
