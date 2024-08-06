/*
Link - https://leetcode.com/problems/palindromic-substrings/description/
*/

//  Create dp matrix of string characters, right upper triangle cells consists of all substrings,check palindrome by first and letter letter equality - O(n^2) 
//No better approach than this
public int countSubstrings(String s) 
{
  int count=0;
  boolean dp[][]=new boolean[s.length()][s.length()];                       //By default, all cells false
  for(int length=1;length<=s.length();length++)                                            //going in dp by diagonals,g=0 first diagonal 0
  {
      for(int i=0,j=length-1;j<dp.length;i++,j++)                                  //i is row,j is column=diag number
      {
          if(length==1)
            
          {
              dp[i][j]=true;                                              //all single letter cells true
              count++;
          }
          else if(length==2)
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
