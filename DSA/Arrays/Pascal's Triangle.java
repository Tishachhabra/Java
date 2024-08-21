/* Variation 1: Given row number r and column number c. Print the element at position (r, c) in Pascal’s triangle.
Sol- The ans is (r-1)Combination(c-1) = r! /(c! * (r-c)!) ; Calc each factorial alg then apply formulae -- O(r)+O(c)+O(r-c)
OR
Use shortcut to calc combo ; run until denominator is 1. -- O(n
*/

public static long nCr(int r, int c) 
{
    long res = 1;
    for (int col = 0; col < c; col++)           // will go from 0 to c-1 bcoz in dividing we need smaller first to get right ans
    {            
        res = res * (r - col);
        res = res / (col + 1);
    }
    return res;
}

// Variation 2: Given the row number n. Print the n-th row of Pascal’s triangle.

class Solution 
{
    ArrayList<Long> RowOfPascalTriangle(int r) 
    {
        ArrayList<Long> line=new ArrayList<>();
        line.add(1L);
        long ans=1;
        for(int i=1;i<r;i++)                              // sare columns se 1 kam chlega bcoz 1 has been added
        {
            ans*= (r-i);
            ans/=i; 
            line.add(ans);
        }
        return line;
    }
}

// Variation 3: Given the number of rows n. Print the first n rows of Pascal’s triangle.
class Test{
public static long[] generate(int r) 
{
  long[]arr=new long[r];
  long ans=1;
  arr[0]=1;
  for(int i=1;i<r;i++)
  { 
    ans=ans*(r-i);
    ans=ans/i;
    arr[i]=ans;
  }
  return arr;
}

public static long[][] pascalTriangle(int N) 
{
	long[][]res = new long[N][N];            //for whole triangle
	for(int i=0;i<N;i++)                    //for every row generate
		res[i]=generate(i+1);                //lgatar dalte rho generate krke
  return res;
}
}
