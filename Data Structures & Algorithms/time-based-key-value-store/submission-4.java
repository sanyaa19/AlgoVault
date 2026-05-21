class TimeMap {
    HashMap<String, HashMap<Integer , String>> key_time_val;
    HashMap<String, ArrayList<Integer>> key_time;

    public TimeMap() {
        key_time_val = new HashMap<>();
        key_time = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(key_time_val.containsKey(key)){
            HashMap<Integer , String> t_v = key_time_val.get(key);
            t_v.put(timestamp , value);

            ArrayList<Integer> t = key_time.get(key);
            t.add(timestamp);
        }
        else{
            HashMap<Integer , String> t_v = new HashMap<>();
            t_v.put(timestamp , value);
            key_time_val.put(key , t_v);

            ArrayList<Integer> t = new ArrayList<>();
            t.add(timestamp);
            key_time.put(key , t);
        }
    }
    
    public String get(String key, int timestamp) {
        if(!key_time.containsKey(key)) return "";

        ArrayList<Integer> list = key_time.get(key);

        int left = 0;
        int right = list.size() - 1;

        int ans = -1;

        while(left <= right){
            int mid = left + (right - left)/2;

            if(list.get(mid) == timestamp){
                ans = list.get(mid);
                break;
            }

            if(list.get(mid) < timestamp){
                ans = list.get(mid);
                left = mid + 1;
            }

            else{
                right = mid - 1;
            }
        }

        if(ans == -1) return "";

        HashMap<Integer , String> map = key_time_val.get(key);

        return map.get(ans);
    }
}
