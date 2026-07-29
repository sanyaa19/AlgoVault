class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for(String s : strs){
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> list = new ArrayList<>();

        int i = 0;
        int j = 0;

        while(i < str.length()){

            while(str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));
            i = j+1;
            j = i+length;

            list.add(str.substring(i, j));
            i = j;
        }

        return list;
    }
}
