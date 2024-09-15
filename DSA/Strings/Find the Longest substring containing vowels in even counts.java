//Use bitmasking and toggling to save cur states
// cur states will be searched in map, if found middle substring is nullifying. (Like subarray with a target , rev eng)
// Use bit number for vowels, XOR for toggling whenever vowel found

public int findTheLongestSubstring(String s) {
    int n = s.length();
    int mask = 0;
    int maxLength = 0;
    HashMap<Integer, Integer> m = new HashMap<>();        //to store cur masks
    m.put(0, -1);                                          //essential to see whether 0 appears again (all even counted vowels)
    
    for (int i = 0; i < n; i++) {
        char c = s.charAt(i);
        if (c == 'a') mask ^= (1 << 0);                    //XOR mask with bitmask to toggle corresponding vowel
        else if (c == 'e') mask ^= (1 << 1);
        else if (c == 'i') mask ^= (1 << 2);
        else if (c == 'o') mask ^= (1 << 3);
        else if (c == 'u') mask ^= (1 << 4);
        
        if (m.containsKey(mask)) {                          //if found update length with middle substring
            maxLength = Math.max(maxLength, i - m.get(mask));
        } else {                                            //if not found then only put
            m.put(mask, i);
        }
    }
    return maxLength;
}
