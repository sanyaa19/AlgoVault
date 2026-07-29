class Solution {
    public int longestConsecutive(int[] nums) {
        if(nums.length <= 1) return nums.length;

        HashSet<Integer> set = new HashSet<>();

        for(int n : nums) set.add(n);

        int max = 0;
        for(int i : nums){
            if(!set.contains(i-1)){
                int count = 1;
                int num = i;

                while(set.contains(++num)){
                    count++;
                }

                max = Math.max(max, count);
            }
        }

        return max;
    }
}
