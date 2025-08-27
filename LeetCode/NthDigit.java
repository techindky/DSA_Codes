class Solution {
    public int findNthDigit(int n) {
        if (n < 10)
            return n;
        int num = 1;
        int tens = 10;
        int no_of_digits = 1;
        while (n > 0) {
            if (num >= tens) {
                no_of_digits++;
                tens *= 10;
            }
            if (n <= no_of_digits) {
                num /= (int) Math.pow(10, no_of_digits - n);
                break;
            }
            num++;
            n -= no_of_digits;
        }
        return num % 10;
    }
}
