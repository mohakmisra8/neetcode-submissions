class Solution {

    public String encode(List<String> strs) {
        final var sb = new StringBuilder();
        for(var s: strs) {
            sb.append(s.length()).append("$").append(s);
        }
        return sb.toString();

    }

    public List<String> decode(String str) {
        final var res = new ArrayList<String>();
        var i =0;
        while (i<str.length()) {
            var j = str.indexOf("$", i);
            int len = Integer.parseInt(str.substring(i, j));
            res.add(str.substring(j + 1, j + 1 + len));
            i = j+1+len;
        }
        return res;
    }
}
