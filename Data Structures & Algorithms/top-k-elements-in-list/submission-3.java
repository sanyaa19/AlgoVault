class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int n : nums){
            map.put(n , map.getOrDefault(n , 0) + 1);
        }

        List<List<Integer>> table = new ArrayList<>();

        for(int i = 0; i <= nums.length; i++){
            table.add(new ArrayList<>());
        }

        for(int n : map.keySet()){
            int idx = map.get(n);
            table.get(idx).add(n);
        }

        int[] res = new int[k];
        int count = 0;

        for(int i = table.size() - 1; i >= 0 && count < k; i--){
            for(int j : table.get(i)){
                res[count++] = j;
                if(count == k) break;
            }
        }

        return res;
    }
}
