/*
Link - https://www.geeksforgeeks.org/find-minimum-number-of-merge-operations-to-make-an-array-palindrome/
*/


// 2 pointer approach left & right - O(n)
static int findMinOps(int[] arr, int n)
{
  int ans = 0;                                                //Initialise no. of merge operations

  for (int i=0,j=n-1; i<=j;)                                  //Start comparing from corner elements
  {
    if (arr[i] == arr[j])                                      // If corner elements are same, problem reduces to arr[i+1..j-1]
    {
      i++;
      j--;
    }               
      
    else if (arr[i] > arr[j])                                  // If left element is greater,then merge right two elements
    {
      j--;
      arr[j] += arr[j+1] ;
      ans++;
    }
    else                                                       // Else we merge left two elements
    {
      i++;
      arr[i] += arr[i-1];
      ans++;
    }
  }

  return ans;
}
