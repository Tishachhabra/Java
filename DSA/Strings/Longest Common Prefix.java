// Link - https://leetcode.com/problems/longest-common-prefix/description/ 

// Lexicographically sort Strings, check frst & last string
public String longestCommonPrefix(String[] v) 
{
    StringBuilder ans = new StringBuilder();
    Arrays.sort(v);
    String first = v[0];
    String last = v[v.length-1];
    for (int i=0; i<first.length(); i++) 
    {
        if (first.charAt(i) != last.charAt(i)) 
        {
            return ans.toString();
        }
        ans.append(first.charAt(i));
    }
    return ans.toString();
}

// Best - Vertical scanning -  O(S) where S= all characters in all strings of arr
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);

            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || strs[j].charAt(i) != c)
                    return strs[0].substring(0, i);
            }
        }
        return strs[0];
    }


