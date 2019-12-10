class Solution {
    public boolean isMatch(String s, String p) {
        // doesn't work when .*c for aabbb  since there isn't c
        int sindex = 0;
        int slength = s.length();
        int pindex = 0;
        int plength = p.length();
        while (sindex < slength) {
            if (pindex >= plength) {
                return false;
            }
            char pChar = p.charAt(pindex);
            if (pindex + 1 < plength && p.charAt(pindex + 1) == '*') {
                if (pChar == '.') {
                    return true;
                }
                while (s.charAt(sindex) == pChar) {
                    sindex += 1;
                    if (sindex >= slength) {
                        return true;
                    }
                }
                pindex += 2;
            } else {
                if (pChar != '.' && s.charAt(sindex) != pChar) {
                    return false;
                }
                sindex += 1;
                pindex += 1;
            }
        }
        if (pindex == plength) {
            return true;
        }
        return false;
    }
}
