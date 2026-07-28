// MEMOIZATION
// class Solution {
//     int[] dp;

//     int stepCost(int[] cost, int idx){
//         if(idx >= cost.length) return 0;

//         if(dp[idx] != -1) return dp[idx];

//         int step1 = cost[idx] + stepCost(cost, idx+1);
//         int step2 = cost[idx] + stepCost(cost, idx+2);

//         return dp[idx] = Math.min(step1,step2);
//     }
//     public int minCostClimbingStairs(int[] cost) {
//         dp = new int[cost.length];
//         Arrays.fill(dp, -1);

//         int ans1 = stepCost(cost, 0);
//         int ans2 = stepCost(cost, 1);

//         return Math.min(ans1, ans2);
//     }
// }

// TABULATION
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 1];

        dp[cost.length] = 0;
        dp[cost.length - 1] = cost[cost.length - 1]; 

        for(int i = cost.length - 2; i >= 0; i--){
            int step1 = cost[i] + dp[i+1];
            int step2 = cost[i] + dp[i+2];
            
            dp[i] = Math.min(step1, step2);
        }

        // int ans1 = dp[0];

        // for(int i = cost.length - 2; i >= 1; i--){
        //     int step1 = cost[i] + dp[i+1];
        //     int step2 = cost[i] + dp[i+2];
            
        //     dp[i] = Math.min(step1, step2);
        // }

        // int ans2 = dp[1];

        //return Math.min(ans1, ans2);

        return Math.min(dp[0], dp[1]);
    }
}
