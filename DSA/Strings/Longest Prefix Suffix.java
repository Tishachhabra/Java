/* 
Link - https://practice.geeksforgeeks.org/problems/longest-prefix-suffix2527/1
*/

//Naive approach
//all prefixes check with same length suffixes - O(n^3)
int lps(String s) 
{
    int i=0,j=s.length()-1,count=0;
    for(;i<s.length()-1;i++,j--)
    {
        if(s.substring(0,i+1).equals(s.substring(j,s.length())))          
        {
           count=Math.max(count,s.substring(0,i+1).length());                 //if prefix==suffix update count for largest
        }
    }
    return count;
}

//Best approach
//pi table of kmp making - O(n)
int lps(String s) 
{
    int n = s.length();
    int[] lps = new int[n];                            //length of lps found uptil i index
    int i = 0, j =1;
    lps[0] = 0;
    while(j <n)                                        //j se traverse i ko as a pattern
    {
      if(s.charAt(i) == s.charAt(j))
      {
          lps[j] = i + 1 ;                            
          i++;
          j++;
      }
      else
      {
        if(i == 0)                                     //hasnt matched yet
        {
          lps[j] = 0;
          j++;
        }
        else
        {
          i = lps[i-1];                               
        }
      }
    }
    return lps[n-1];                        //not whole string can be the answer
}
