// Bruteforce - find all subarrays by nested loop -- O(n^2)
// Best - For any ele sum will include the ele * no. of times it had occurred in diff subarrays. Formulae to find how many times come- (i+1)*(n-i) i.e. (ways to start)*(ways to end) == combinatrics

class Solution {
    public int subarraySum(int[] arr) {
        int n=arr.length;
        int result=0;
        for(int i=0;i<n;i++)                        //one traverse to find for every ele
        {
            int a=(i+1)*(n-i);                      //Number of times it can appear by combination multiply
            result+=a*arr[i];                      // calc ele contri to sum
            
        }
        return result;
    }
}
