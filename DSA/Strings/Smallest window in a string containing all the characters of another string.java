// Acquire - release , boolean maintain f1 for acquire flag and f2 for release flag , matchcount & desiredmatchcount, map



class Solution
{
    public static String smallestWindow(String s, String p)
    {
        int i=-1;
        int j=-1;
        String ans="";
        int matchcount=0;
        int desiredmatchcount=p.length();
        HashMap<Character,Integer> map2=new HashMap<>();
        for(int k=0;k<p.length();k++)
        {
            char ch=p.charAt(k);
            map2.put(ch,map2.getOrDefault(ch,0)+1);
        }
        
        HashMap<Character,Integer> map1=new HashMap<>();
        while(true)
        {
            boolean f1=false,f2=false;
            //acquire
            while(i<s.length()-1 && matchcount!=desiredmatchcount)
            {
                i++;
                char ch=s.charAt(i);
                map1.put(ch,map1.getOrDefault(ch,0)+1);
                if(map1.getOrDefault(ch,0)<=map2.getOrDefault(ch,0))
                {
                    matchcount++;
                }
                f1=true;
            }
            
            //collect ans & reduce
            while(j<i && matchcount==desiredmatchcount)
            {
                String currans=s.substring(j+1,i+1);
                if(ans.length()==0 || currans.length()<ans.length())
                {
                    ans=currans;
                }
                j++;
                char ch=s.charAt(j);
                if(map1.get(ch)==1)
                {
                    map1.remove(ch);
                }
                else
                map1.put(ch,map1.get(ch)-1);
                if(map1.getOrDefault(ch,0)<map2.getOrDefault(ch,0))
                matchcount--;
                f2=true;
            }
            if(f1==false && f2==false)
            break;
        }
        if(ans.length()==0)
        return "-1";
        return ans;
    }
}
