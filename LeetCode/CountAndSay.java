class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder("1");
        while (n-- > 1) {
            StringBuilder row = new StringBuilder();
            int count = 1;
            for (int i = 1; i < result.length(); i++) {
                if (result.charAt(i) == result.charAt(i-1)) {
                    count++;
                } else {
                    row.append(count).append(result.charAt(i-1));
                    count = 1;
                }
            }
            row.append(count).append(result.charAt(result.length() - 1));
            result = row;
        }
        return result.toString();
    }
}
