class TrieNode {
    Map<Character, TrieNode> children = new HashMap();
    boolean is_word = false;
}

class Solution {
    TrieNode root;
    Integer[] memo;
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        root = buildTrie(dictionary);
        memo = new Integer[n + 1];
        return dp(0, n, s);
    }
    
    private int dp(int start, int n, String s) {
        if (start == n) {
            return 0;
        }
        if (memo[start] != null) {
            return memo[start];
        }

        TrieNode node = root;
        int ans = dp(start + 1, n, s) + 1;
        for (int end = start; end < n; end++) {
            char c = s.charAt(end);
            if (!node.children.containsKey(c)) {
                break;
            }
            node = node.children.get(c);
            if (node.is_word) {
                ans = Math.min(ans, dp(end + 1, n, s));
            }
        }
        
        return memo[start] = ans;
    }
    
    private TrieNode buildTrie(String[] dictionary) {
        TrieNode root = new TrieNode();
        for (String word : dictionary) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                node.children.putIfAbsent(c, new TrieNode());
                node = node.children.get(c);
            }
            node.is_word = true;
        }
        return root;
    }
}

/*
### APPROACH 2 : BOTTOM UP DP WITH SUBSTRING METHOD
class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        var dictionarySet = new HashSet<>(Arrays.asList(dictionary));
        var dp = new int[n + 1];

        for (int start = n - 1; start >= 0; start--) {
            dp[start] = dp[start + 1] + 1;
            for (int end = start; end < n; end++) {
                var curr = s.substring(start, end + 1);
                if (dictionarySet.contains(curr)) {
                    dp[start] = Math.min(dp[start], dp[end + 1]);
                }
            }
        }

        return dp[0];
    }
}
*/
