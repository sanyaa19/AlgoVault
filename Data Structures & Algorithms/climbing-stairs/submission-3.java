// MEMOIZATION
// class Solution {
//     int[] dp;
//     int climb(int target){
//         if(target <= 1) return 1; 

//         if(dp[target] != 0) return dp[target];

//         return dp[target] = climb(target - 1) + climb(target - 2); 

//     }
//     public int climbStairs(int n) {
//         dp = new int[n + 1];
        
//         return climb(n);
//     }
// }

// TABULATION
// class Solution {
//     public int climbStairs(int n) {
//         int[] dp = new int[n+1];

//         dp[0] = 1;
//         dp[1] = 1;

//         for(int i = 2; i <= n; i++){
//             dp[i] = dp[i-1] + dp[i-2];
//         }

//         return dp[n];
//     }
// }

// SPACE OPTIMIZATION
class Solution {
    public int climbStairs(int n) {

        int prev1 = 1;
        int prev = 1;

        for(int i = 2; i <= n; i++){
            int curr = prev + prev1;

            prev1 = prev;
            prev = curr;
        }

        return prev;
    }
}
