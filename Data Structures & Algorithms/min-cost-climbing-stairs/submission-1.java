class Solution {
    int[] dp;

    int stepCost(int[] cost, int idx){
        if(idx >= cost.length) return 0;

        if(dp[idx] != -1) return dp[idx];

        int step1 = cost[idx] + stepCost(cost, idx+1);
        int step2 = cost[idx] + stepCost(cost, idx+2);

        return dp[idx] = Math.min(step1,step2);
    }
    public int minCostClimbingStairs(int[] cost) {
        dp = new int[cost.length];
        Arrays.fill(dp, -1);

        int ans1 = stepCost(cost, 0);
        int ans2 = stepCost(cost, 1);

        return Math.min(ans1, ans2);
    }
}
