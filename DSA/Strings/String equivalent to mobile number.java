/*
Link :- https://www.geeksforgeeks.org/convert-sentence-equivalent-mobile-numeric-keypad-sequence/
*/

//ASCII conversions
String printSequence(String S) 
{ 
    String ans="";
    String  num[]
        = { "2",    "22",  "222", "3",   "33", "333",
            "4",    "44",  "444", "5",   "55", "555",
            "6",    "66",  "666", "7",   "77", "777",
            "7777", "8",   "88",  "888", "9",  "99",
            "999",  "9999" };
    for(int i=0;i<S.length();i++)
    {
        if(S.charAt(i)==' ')
        ans+="0";
        else
        {
            int pos=S.charAt(i)-'A';
            ans+=num[pos];
        }
    }
    return ans;
}
