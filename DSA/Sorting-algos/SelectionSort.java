void selectionSort(int arr[], int n)
	{
	    for(int i=0;i<arr.length-1;i++)
	    {
	        int pos=i;
	        for(int j=i+1;j<arr.length;j++)
	        {
	            if(arr[j]<arr[pos])
	            pos=j;
	        }
	        int temp=arr[i];
	        arr[i]=arr[pos];
	        arr[pos]=temp;
	    }
	}
