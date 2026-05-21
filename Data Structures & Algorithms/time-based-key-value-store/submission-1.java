class TimeMap {
    HashMap<String , String[]> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if(map.containsKey(key)){
            String[] list = map.get(key);
            list[timestamp] = value;
        }
        else{
            String[] val_arr = new String[10000000];
            val_arr[timestamp] = value;
            map.put(key , val_arr);
        } 
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)) return "";

        String[] list = map.get(key);

        int right = timestamp;

        while(right >= 0){
            if(list[right] != null) return list[right];

            right--;
        }

        return "";
    }
}
