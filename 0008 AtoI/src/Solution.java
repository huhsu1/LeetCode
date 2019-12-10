class Solution {
    public int myAtoi(String str) {
        if (str.equals(null)) {
            return 0;
        }
        int length = str.length();
        if (length == 0) {
            return 0;
        }
        int index = 0;
        char char1 = str.charAt(index);
        while (char1 == ' ') {
            index += 1;
            if (index >= length) {
                return 0;
            }
            char1 = str.charAt(index);
        }
        boolean negative = false;
        if (char1 == '-') {
            negative = true;
            index += 1;
            if (index >= length) {
                return 0;
            }
            char1 = str.charAt(index);
        } else if (char1 == '+') {
            index += 1;
            if (index >= length) {
                return 0;
            }
            char1 = str.charAt(index);
        }
        int number = 0;
        if (negative) {
            while (char1 >= 48 && char1 <= 57) {
                if (number < Integer.MIN_VALUE / 10 || 
                    (number == Integer.MIN_VALUE / 10 && (char1 - 48) > 8)) {
                    return Integer.MIN_VALUE;
                }
                number = number * 10 - (char1 - 48);
                index += 1;
                if (index == length) {
                    break;
                }
                char1 = str.charAt(index);
            }
        } else {
            while (char1 >= 48 && char1 <= 57) {
                if (number > Integer.MAX_VALUE / 10 || 
                    (number == Integer.MAX_VALUE / 10 && (char1 - 48) > 7)) {
                    return Integer.MAX_VALUE;
                }
                number = number * 10 + (char1 - 48);
                index += 1;
                if (index == length) {
                    break;
                }
                char1 = str.charAt(index);
            }
        }
        return number;
    }
}
