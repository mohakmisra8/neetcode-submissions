class Solution {

    public String encode(List<String> strs) {
        // take a string builder and add % after each word and return that string
        StringBuilder sb = new StringBuilder();
        for(String s: strs) {
            sb.append(s.length()).append('#').append(s);
        }

        return sb.toString();

    }

    public List<String> decode(String str) {
        // split the string on % and return all the words 
        List<String> res = new ArrayList<>();
        int i =0;
        while(i <str.length()) {
            int j = i;
            // read difitys until # to get the length
            while (str.charAt(j) != '#') {
                j++;
            }

            int len = Integer.parseInt(str.substring(i, j));
            // read exactly len characters after the #
            res.add(str.substring(j+1,j+1+len));
            i = j+1+len;
        }

        return res;

    }
}
