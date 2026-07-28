class Solution {
    int[] dp;
    int climb(int target){
        if(target == 0){
            return dp[target] = 1;
        }

        if(target < 0) return 0;

        if(dp[target] != 0) return dp[target];

        return dp[target] = climb(target - 1) + climb(target - 2); 

    }
    public int climbStairs(int n) {
        dp = new int[n + 1];
        
        return climb(n);
    }
}
