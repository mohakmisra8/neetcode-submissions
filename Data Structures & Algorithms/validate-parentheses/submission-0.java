class Solution {
    public boolean isValid(String s) {
        // remove all the valid occurences of brackets
        // if it does not contain anymore then true
        // otherwise false
        while (s.contains("()") ||s.contains("{}")||s.contains("[]")) {
            s = s.replace("()", "");
            s = s.replace("{}", "");
            s = s.replace("[]", "");
        }

        return s.isEmpty();
        
    }
}
