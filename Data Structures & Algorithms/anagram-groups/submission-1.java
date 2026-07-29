class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, Integer> map = new HashMap<>();
        List<List<String>> res = new ArrayList<>();

        for(String s : strs){

            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String st = new String(arr);

            if(map.containsKey(st)){
                int idx = map.get(st);
                res.get(idx).add(s);
            }
            else{
                res.add(new ArrayList<>());
                int idx = res.size() - 1;
                res.get(idx).add(s);
                map.put(st, idx);
            }
        }
        return res;
    }
}
