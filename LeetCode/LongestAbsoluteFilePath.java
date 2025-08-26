class Solution {
    public int lengthLongestPath(String input) {
        String[] paths = input.split("\n");
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        int maxLen = 0;

        for (String path : paths) {
            String name = path.replaceAll("^\t+", "");
            int depth = path.length() - name.length();

            while (stack.size() > depth + 1) {
                stack.pop();
            }

            int currLen = stack.peek() + name.length();
            if (name.contains(".")) {
                maxLen = Math.max(maxLen, currLen);
            } else {
                stack.push(currLen + 1);
            }
        }
        return maxLen;
    }
}
