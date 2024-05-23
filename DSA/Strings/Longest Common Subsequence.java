/*
Link-https://leetcode.com/problems/longest-common-subsequence/description/

Naive Approach-Generate all the possible subsequences and find the longest among them that is present in both strings using recursion - O(2^(m+n))
Better - use dp (recursion or tabulation) , dp [i][j] will represent length of common subseq found until String1 of i length and String2 of j length. +1 length ki matrix bnana to 0 index pe null string hogi. But strings ko 0 based indexing se traverse krna .
*/

public int longestCommonSubsequence(String text1, String text2) 
{
    int m=text1.length();
    int n=text2.length();
    int dp[][]=new int[m+1][n+1];                                //one + to store null string at 0 index
    for(int i=0;i<=m;i++)
    {
        for(int j=0;j<=n;j++)
        {
            if(i==0 || j==0)                                      //first row or first col of matrix will be 0
            dp[i][j]=0;
            else if(text1.charAt(i-1)==text2.charAt(j-1))          //match (0-indexed strings
            dp[i][j]=dp[i-1][j-1]+1;
            else                                                    //no match
            dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        }
    }
    return dp[m][n];
}
