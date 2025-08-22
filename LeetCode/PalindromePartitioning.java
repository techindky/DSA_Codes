import java.util.*;

class Solution {
    public List<List<String>> partition(String s) {
        int n = s.length();
        boolean[][] pal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || pal[i + 1][j - 1])) {
                    pal[i][j] = true;
                }
            }
        }
        List<List<String>> res = new ArrayList<>();
        Deque<String> path = new ArrayDeque<>();
        dfs(0, s, pal, path, res);
        return res;
    }

    private void dfs(int i, String s, boolean[][] pal, Deque<String> path, List<List<String>> res) {
        if (i == s.length()) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int j = i; j < s.length(); j++) {
            if (pal[i][j]) {
                path.addLast(s.substring(i, j + 1));
                dfs(j + 1, s, pal, path, res);
                path.removeLast();
            }
        }
    }
}
