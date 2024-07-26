// O (n) - Find min and max element(breaking pt) by linear search + meet-in-middle (handle circular bounds)
// O(logn) - Search breaking pt by binary search

public boolean pairInSortedRotated(int arr[], int n,int x)
    {
        int i;
        for (i = 0; i < n - 1; i++)        //Find breaking pt by linear search
            if (arr[i] > arr[i + 1])
                break;
        int l = (i + 1) % n;              //index of smallest element
        int r = i;                        //index of largest element
        while (l != r) 
        {
            if (arr[l] + arr[r] == x)        //pair found
                return true;
            if (arr[l] + arr[r] < x)         //cur pair is less then l++ in circle
                l = (l + 1) % n;
            else
                r = (n + r - 1) % n;        //decrease pointer in circle
        }
        return false;
    }
