// 1 traversal+prev maintain+at every i : if arr[i].start<=arr[prev].end then arr[prev].end update(merge) 
// else prev++ and put arr[prev]=arr[i] this way 0 to prev will be ans
//-- O(nlogn +n+n)
public int[][] overlappedInterval(int[][] Intervals)
{
    Arrays.sort(Intervals, (a,b)-> Integer.compare(a[0], b[0]));            //sorted 2d arr based on start timings
    int n=Intervals.length;
    int prev=0;
    for(int i=1;i<n;i++)
    {
        if(Intervals[i][0]<=Intervals[prev][1])                            //if current start can be merged in prev
        {
            Intervals[prev][1]=Math.max(Intervals[prev][1],Intervals[i][1]);        
        }
        else
        {
            prev++;                                                        ////to maintain merged length array
            Intervals[prev] = Intervals[i];                                //can be directly submitted
        }
    }
    return Arrays.copyOf(intervals, prev + 1); // Copy only the relevant portion
}
