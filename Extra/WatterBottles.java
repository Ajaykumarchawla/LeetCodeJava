package Extra;

// 1518. Water Bottles
// Solved
// Easy
// Topics
// premium lock icon
// Companies
// Hint
// There are numBottles water bottles that are initially full of water. You can exchange numExchange empty water bottles from the market with one full water bottle.

// The operation of drinking a full water bottle turns it into an empty bottle.

// Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

// Example 1:

// Input: numBottles = 9, numExchange = 3
// Output: 13
// Explanation: You can exchange 3 empty bottles to get 1 full water bottle.
// Number of water bottles you can drink: 9 + 3 + 1 = 13.
// Example 2:

// Input: numBottles = 15, numExchange = 4
// Output: 19
// Explanation: You can exchange 4 empty bottles to get 1 full water bottle. 
// Number of water bottles you can drink: 15 + 3 + 1 = 19.

// Constraints:

// 1 <= numBottles <= 100
// 2 <= numExchange <= 100

public class WatterBottles {
    public int numWaterBottles(int numBottles, int numExchange) {
        int count = 0;
        int mod = 0;
        int newNumBottles = 0;
        while ((numBottles) > 0) {
            count = count + numBottles;
            newNumBottles = (numBottles + mod) / numExchange;
            mod = (numBottles + mod) % numExchange;
            numBottles = newNumBottles;
        }
        return count;
    }
}

// Test Cases:
// 1
// 2
// 5
// 10
// 2
// 2
// 9
// 3
// 15
// 4
// 8
// 4
// 100
// 99
// 100
// 2