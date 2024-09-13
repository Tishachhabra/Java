/*
Link - https://leetcode.com/problems/longest-substring-without-repeating-characters/
*/

// Set, 2 pointer approach
public int lengthOfLongestSubstring(String s) 
{
    int n = s.length();
    int maxLength = 0;
    Set<Character> charSet = new HashSet<>();
    int left = 0;
    
    for (int right = 0; right < n; right++) {
        if (!charSet.contains(s.charAt(right))) 
        {
            charSet.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }
         else 
         {
            while (charSet.contains(s.charAt(right))) {
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(right));
        }
    }
    
    return maxLength;
}


// Store char with index in map then update start whenever found duplicate ( less map opertions)


public int lengthOfLongestSubstring(String s) {
if (s.isEmpty()) return 0;
        
        int max = 0, start = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            
            // If character already seen, update start position
            if (map.containsKey(ch) && map.get(ch) >= start)                     //if duplicate is within window
            {
                start = map.get(ch) + 1;
            }
            
            // Update the character index
            map.put(ch, i);
            
            // Update max length
            max = Math.max(max, i - start + 1);
        }
        
        return max;
}
