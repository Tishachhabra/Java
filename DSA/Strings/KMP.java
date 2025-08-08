/* Best algo for searching pattern in string - O(n+m) since it does not include backtracking of text pointer (unlike naive algo)
  Make pi table of pattern - LPS array of pat[0..i] (in actual it is dp which works bottom to top and LPS[last] is ans of Longest prefix suffix in given string)
  use this pi table to move pattern pointer and text pointer will only traverse along text in one go
*/
  

class Solution {
    public int[] LPS(String pat) {              // function to make pi table of pattern
        int n = pat.length();
        int[] lps = new int[n];                
        int length = 0;                         // Length of previous LPS
        int i = 1;                              // which will traverse all the way along pattern
        
        while (i < n) {
            if (pat.charAt(i) == pat.charAt(length)) {
                length++;
                lps[i] = length;                //update index in lps[i] to know that current letter (at i) is been seen before at 'length' index
                i++;
            } else {                            //charc mismatch
                if (length != 0) {              //means we have to startover ; use pi table to put lenghth pointer to back
                    length = lps[length - 1];
                } else {
                    lps[i] = 0;                
                    i++;
                }
            }
        }
        return lps;
    }

    public ArrayList<Integer> search(String pat, String txt) {
        int[] lps = LPS(pat);
        int n = txt.length();
        int m = pat.length();

        ArrayList<Integer> result = new ArrayList<>();
        int i = 0; // Pointer for txt
        int j = 0; // Pointer for pat

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
            }

            if (j == m) {
                result.add(i - j); // Add the starting index of the text where pattern was found
                j = lps[j - 1]; // Continue to look for other occurrences
            } else if (i < n && txt.charAt(i) != pat.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1]; // Use LPS array to skip
                } else {
                    i++;
                }
            }
        }

        return result; // Return the list of all occurrences
    }
}
