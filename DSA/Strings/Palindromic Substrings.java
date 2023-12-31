/*
Link - https://leetcode.com/problems/palindromic-substrings/description/
*/

//  Create dp matrix of string characters, right upper triangle cells consists of all substrings,check palindrome by first and letter letter equality
public int countSubstrings(String s) 
{
  int count=0;
  boolean dp[][]=new boolean[s.length()][s.length()];                       //By default, all cells false
  for(int g=0;g<s.length();g++)
  {
      for(int i=0,j=g;j<dp.length;i++,j++)
      {
          if(g==0)
          {
              dp[i][j]=true;                                              //all single letter cells true
              count++;
          }
          else if(g==1)
          {
              if(s.charAt(i)==s.charAt(j))
              {
                  dp[i][j]=true;
                  count++;
              }
          }
          else
          {
              if(s.charAt(i)==s.charAt(j) && dp[i+1][j-1]==true)
              {
                  dp[i][j]=true;
                  count++;
              }
          }
      }
  }
return count;
}
