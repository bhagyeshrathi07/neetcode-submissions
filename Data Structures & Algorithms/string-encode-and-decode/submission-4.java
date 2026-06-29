class Solution {

    public String encode(List<String> strs) {
        if(strs.isEmpty()) return "";
        StringBuilder encodedString = new StringBuilder();

        for(String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    // 3#att4#atat2#hi
    public List<String> decode(String str) {
        if(str.length() == 0) return new ArrayList<>();
        List<String> result = new ArrayList<>();

        int i = 0;
        while(i < str.length()) {
            int j = i;
            while(j < str.length() && str.charAt(j) != '#') {
                j++;
            }
            int len = Integer.parseInt(str.substring(i, j));
            i = j + 1;
            j = i + len;
            result.add(str.substring(i, j));
            i = j;
        }
        return result;
    }
}
