/* 
Link - leetcode.com/problems/word-break-ii/description/?envType=daily-question&envId=2024-05-25

Recursion (bottom up approach) - traversal frm i to str.length()-1 extract possible words from dict and add to solution taken from recursion of subproblems(bottom)
DP(bottom up)-traversal from end(small subsprblms) , for every word possible on that index: add in dp[i+word.length()] storing all solutions from i+word.length() to str.length().

*/

static List<String> wordBreak(int n, HashSet<String> Dict, String s)
	{
		int l = s.length();
		List<List<String> > dp = new ArrayList<>();              //store every possible word in i index

		for (int i = 0; i < l; i++)                               //store possible words
		{
			List<String> arr = new ArrayList<>();
			for (int j = i + 1; j < l + 1; j++) 
			{
				if (Dict.contains(s.substring(i, j)))
					arr.add(s.substring(i, j));
			}
			dp.add(arr);
		}

		                      // From bottom up approach form the string
		List<List<String> > sol = new ArrayList<>();                    //sol[i] contains sentences possible upto that index(subprblm)
		for (int i = 0; i < l; i++) 
    {
			sol.add(new ArrayList<>());
		}
		for (int i = l - 1; i >= 0; i--)                               //traverse frm end (small to big prblms -storing)
    {
			List<String> ans = new ArrayList<>();                        //strings possible at every i index
			if (dp.get(i).size() != 0)                                   //if words are possible at i index
      {
				for (String word : dp.get(i))                              
        {
					// If word is last word in string directly append
					if (i + word.length() == l)
						ans.add(word);

					// Combine with each word present already and store
					else if (sol.get(i + word.length()).size()!= 0) 
          {
						for (String w : sol.get(i + word.length()))
							ans.add(word + " " + w);
					}
				}
			}
			sol.set(i, ans);
		}

		return sol.get(0);                                            //strings possible from 0 index to last
	}



