class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int right = heights.length - 1;

        int ans = 0;
        while(left < right){
            int width = right - left;
            int height = 0;
            if(heights[left] <= heights[right]){
                height = heights[left];
                left++;
            }
            else{
                height = heights[right];
                right--;
            }

            ans = Math.max(ans, height*width);
        }

        return ans;
    }
}
