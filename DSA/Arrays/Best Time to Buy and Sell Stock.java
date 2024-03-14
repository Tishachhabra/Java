/*
Link - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
*/

//Greedy approach - single traversal, if current price is lower than buy price then update , if greater than check if max profit needs to be updated
public int maxProfit(int prices[], int n)
    {
        int buy = prices[0], max_profit = 0;                  //Initialise buy price to be first one
        for (int i = 1; i < n; i++) 
          {
            if (buy > prices[i])                              // Checking for lower buy value
                buy = prices[i];

            else if (prices[i] - buy > max_profit)          // Checking for higher profit
                max_profit = prices[i] - buy;
        }
        return max_profit;
    }
