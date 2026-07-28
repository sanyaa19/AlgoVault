class Solution {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        
        int prev = nums[0];
        int prev1 = 0;

        for(int i = 1; i < nums.length - 1; i++){
            int pick = nums[i] + prev1;
            int notPick = prev;

            prev1 = prev;
            prev = Math.max(pick , notPick);
        }

        int ans1 = prev;

        prev = nums[1];
        prev1 = 0;

        for(int i = 2; i < nums.length; i++){
            int pick = nums[i] + prev1;
            int notPick = prev;

            prev1 = prev;
            prev = Math.max(pick , notPick);
        }

        int ans2 = prev;

        return Math.max(ans1, ans2);
    }
}
