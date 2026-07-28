// MEMOIZATION
class Solution {
    int[] dp;
    int climb(int target){
        if(target <= 1) return 1; 

        if(dp[target] != 0) return dp[target];

        return dp[target] = climb(target - 1) + climb(target - 2); 

    }
    public int climbStairs(int n) {
        dp = new int[n + 1];
        
        return climb(n);
    }
}

// TABULATION
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];

//         dp[0] = 
//     }
// }
