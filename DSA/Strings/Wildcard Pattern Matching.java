//By recursion ,memoization ,dp
// DP Linewise traversal : 3 major cases ( match / * / not match)  

static boolean strmatch(String str, String pattern,int n, int m)          //n-str length , m-pattern length (containing wild chars)
    {
        // empty pattern can only match with empty string
        if (m == 0 && n==0)
          return true;

        boolean[][] dp = new boolean[n + 1][m + 1];          //use 1-based indexing , so 0 to n table
        // empty pattern can match with empty string
        dp[0][0] = true;

        // Only '*' can match with empty string
        for (int j = 1; j <= m; j++)                         //n or str pointer is kept 0 here = null string
            if (pattern.charAt(j - 1) == '*')
                dp[0][j] = dp[0][j - 1];                     //agar * hi hue bas then ok , if there is any alphabet then false

        // Bottom - up : linewise tabulation
        for (int i = 1; i <= n; i++)
        {
            for (int j = 1; j <= m; j++)
            {
                if (pattern.charAt(j - 1) == '*')
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];        // either it * is taking null / one char match of str

                // Match occur if
                // (a) current character of pattern is '?'
                // (b) characters actually match in both 
                else if (pattern.charAt(j - 1) == '?' || str.charAt(i - 1) == pattern.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];                      // both pointer advance=chars match
                else                                                  // not matching chars
                    dp[i][j] = false;
            }
        }

        return dp[n][m];               
    }
