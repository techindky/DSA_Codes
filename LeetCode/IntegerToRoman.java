class Solution {
    public String intToRoman(int num) {
        StringBuilder result = new StringBuilder();

        int no_of_thousands = num / 1000;
        num %= 1000;
        if (no_of_thousands > 0) {
            result.append("M".repeat(no_of_thousands));
        }
        boolean is_500 = false;
        if (num / 500 == 1) {
            is_500 = true;
            num %= 500;
        }
        int no_of_hundreds = num / 100;
        num %= 100;
        if (no_of_hundreds > 0) {
            if (no_of_hundreds == 4) {
                if (is_500) {
                    result.append("CM");
                } else {
                    result.append("CD");
                }
            } else {
                if (is_500) {
                    result.append("D");
                }
                result.append("C".repeat(no_of_hundreds));
            }
        } else if (is_500) result.append("D");
        boolean is_50 = false;
        if (num / 50 == 1) {
            is_50 = true;
            num %= 50;
        }
        int no_of_tens = num / 10;
        num %= 10;
        if (no_of_tens > 0) {
            if (no_of_tens == 4) {
                if (is_50) {
                    result.append("XC");
                } else {
                    result.append("XL");
                }
            } else {
                if (is_50) {
                    result.append("L");
                }
                result.append("X".repeat(no_of_tens));
            }
        } else if (is_50) result.append("L");
        boolean is_5 = false;
        if (num / 5 == 1) {
            is_5 = true;
            num %= 5;
        }
        if (num > 0) {
            if (num == 4) {
                if (is_5) {
                    result.append("IX");
                } else {
                    result.append("IV");
                }
            } else {
                if (is_5) {
                    result.append("V");
                }
                result.append("I".repeat(num));
            }
        } else if (is_5) result.append("V");
        return result.toString();
    }
}
