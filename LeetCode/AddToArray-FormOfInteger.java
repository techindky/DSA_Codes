class Solution {
    public List<Integer> addToArrayForm(int[] num, int k) {
        List<Integer> result = new ArrayList<>();
        int carry = 0;
        for (int i = num.length - 1; i >= 0; i--) {
            int val = num[i] + carry + (k % 10);
            if (val > 9) {
                result.add(val - 10);
                carry = val / 10;
            } else {
                result.add(val);
                carry = 0;
            }
            k /= 10;
        }
        k += carry;
        while (k > 0) {
            result.add(k % 10);
            k /= 10;
        }
        Collections.reverse(result);
        return result;
    }
}
