//{ Driver Code Starts
import java.util.*;
class Solution
{
    //Function to sort an array using quick sort algorithm.
    static void quickSort(int arr[], int low, int high)
    {
        if(low<high)                        //negative case
        {
        int ind=partition(arr,low,high);    //return correct position of chosen pivot
        quickSort(arr,low,ind-1);
        quickSort(arr,ind+1,high);
        }
    }
    static int partition(int arr[], int low, int high)
    {
        int pivot=low;                      //pivot=first ele
        int i=low+1,j=high;
        while(i<j)
        {
            while(arr[i]<=arr[pivot] && i<=high-1)
            i++;
            while(arr[j]>arr[pivot] && j>=low+1)
            j--;
            
            if(i<j)                         //swap to put smaller on left nd greater on right
            {
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
            }
        }
        int temp=arr[j];                    //put pivot at its correct position
        arr[j]=arr[pivot];
        arr[pivot]=temp;
        return j;
    } 
}
