//Bruteforce : HashMaps for char and counts
public boolean isAnagram(String s, String t) 
{
      if(s.length()!=t.length())
          return false;
      HashMap<Character,Integer> map=new HashMap<Character,Integer>();
      HashMap<Character,Integer> map1=new HashMap<Character,Integer>();
  
      for(int i=0;i<s.length();i++)
      {
          map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            map1.put(t.charAt(i), map1.getOrDefault(t.charAt(i), 0) + 1);
      }
      return map.equals(map1));
}

//Better : Use 2 Aux arrays with indices as alphabets

public boolean isAnagram(String s, String t) 
{
    int[] sArray = new int[26];
    int[] tArray = new int[26];
    if(s.length() != t.length())
        return false;
  
    for(int i=0; i <  s.length(); i++)
    {
        sArray[s.charAt(i) - 97]++;
        tArray[t.charAt(i) - 97]++;    
    }
    
    for(int i = 0; i < 26; i++)
    {
        if(sArray[i] !=  tArray[i] )            //check if both array frequencies same
        {
            return false;
        }
    }
    return true;
}

//Best : 1 Aux array of 26 first increase by s then decraese by t , in end all cells must be 0
public boolean isAnagram(String s, String t) 
{
    if (s.length() != t.length()) return false;
int[] count = new int[26];
for (int i = 0; i < s.length(); i++) {
    count[s.charAt(i) - 'a']++;
    count[t.charAt(i) - 'a']--;
}
for (int val : count)
    if (val != 0) 
      return false;
return true;
}

