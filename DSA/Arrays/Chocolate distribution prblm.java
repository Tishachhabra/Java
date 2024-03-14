/* 
Link :-
www.geeksforgeeks.org/chocolate-distribution-problem/
*/

//After sorting ans will be only subsequent arrays of m size
public long findMinDiff (ArrayList<Integer> a, int n, int m)
{
    Collections.sort(a);                                 //For arrays use Arrays.sort() , for any collection use Collections.sort()
    long minsofar=Integer.MAX_VALUE;
    for(int i=0;i<=a.size()-m;i++)
    {
        minsofar=((a.get(i+m-1)-a.get(i))<minsofar) ? (a.get(i+m-1)-a.get(i)) : minsofar;
    }
    return minsofar;
}

