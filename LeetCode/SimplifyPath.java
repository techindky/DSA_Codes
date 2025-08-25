class Solution {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String res = "";
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') continue;
            StringBuilder temp = new StringBuilder();
            while (i < path.length() && path.charAt(i) != '/') {
                temp.append(path.charAt(i++));
            }
            if (temp.toString().equals(".")) {
                continue;
            } else if (temp.toString().equals("..")) {
                if (!stack.empty()) {
                    stack.pop();
                }
            } else {
                stack.push(temp.toString());
            }
        }
        while (!stack.empty()) {
            res = "/" + stack.pop() + res;
        }
        if (res.length() == 0) {
            return "/";
        }
        return res;
    }
}
