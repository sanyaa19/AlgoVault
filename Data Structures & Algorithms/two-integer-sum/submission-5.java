class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i=0; i<nums.length; i++){
            int dif = target - nums[i];
            if(map.containsKey(dif)){
                return new int[]{map.get(dif), i};
            }
            map.put(nums[i],i);
        }
        return new int[]{0, 0};
    }
}
