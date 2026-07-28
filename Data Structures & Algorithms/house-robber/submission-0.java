class Solution {
    int[] dp;
    int house(int[] nums, int idx){
        if(idx == 0) return nums[0];
        if(idx < 0) return 0;

        if(dp[idx] != -1) return dp[idx];

        int pick = nums[idx] + house(nums, idx-2);
        int notPick = house(nums, idx-1);

        return dp[idx] = Math.max(pick, notPick); 
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        Arrays.fill(dp, -1);

        return house(nums, nums.length-1);
    }
}
