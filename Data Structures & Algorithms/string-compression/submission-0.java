class Solution {
    public int compress(char[] chars) {
        int write = 0;
        int read = 0;

        while(read < chars.length) {
            char c= chars[read];
            int count = 0;
            while(read < chars.length && chars[read] == c) {
                read++;
                count++;
            }
            chars[write++] = c; // write the character

            if(count > 1) {
                for(char digit: String.valueOf(count).toCharArray()) {
                    chars[write++] = digit;
                }
            }
        }
        return write;
        
    }
}