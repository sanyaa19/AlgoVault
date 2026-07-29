class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            
            int left = i+1;
            int right = nums.length - 1;

            while(left < right){
                int sum = nums[i] + nums[left] + nums[right];

                if(sum < 0){
                    left++;
                    while(left < right && nums[left-1] == nums[left]) left++;
                }
                else if(sum > 0){
                    right--;
                    while(left < right && nums[right+1] == nums[right]) right--;
                }
                else{
                    List<Integer> ll = Arrays.asList(nums[i], nums[left], nums[right]);
                    ans.add(ll);

                    left++;
                    right--;
                    
                    while(left < right && nums[left-1] == nums[left]) left++;
                    while(left < right && nums[right+1] == nums[right]) right--;
                }
            }
        }
        
        return ans;        
    }
}
