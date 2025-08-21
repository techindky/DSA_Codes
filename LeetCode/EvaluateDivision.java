import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, List<Edge>> g = new HashMap<>();
        int m = equations.size();

        // Build graph
        for (int i = 0; i < m; i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double k = values[i];
            g.computeIfAbsent(a, z -> new ArrayList<>()).add(new Edge(b, k));
            g.computeIfAbsent(b, z -> new ArrayList<>()).add(new Edge(a, 1.0 / k));
        }

        double[] ans = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String s = queries.get(i).get(0);
            String t = queries.get(i).get(1);
            if (!g.containsKey(s) || !g.containsKey(t)) {
                ans[i] = -1.0;
            } else if (s.equals(t)) {
                ans[i] = 1.0;
            } else {
                ans[i] = dfs(s, t, g);
            }
        }
        return ans;
    }

    private double dfs(String src, String dst, Map<String, List<Edge>> g) {
        Deque<Pair> stack = new ArrayDeque<>();
        Set<String> vis = new HashSet<>();
        stack.push(new Pair(src, 1.0));
        vis.add(src);

        while (!stack.isEmpty()) {
            Pair cur = stack.pop();
            if (cur.var.equals(dst)) return cur.val;
            for (Edge e : g.getOrDefault(cur.var, Collections.emptyList())) {
                if (vis.add(e.to)) {
                    stack.push(new Pair(e.to, cur.val * e.w));
                }
            }
        }
        return -1.0;
    }

    static class Edge {
        String to;
        double w;
        Edge(String t, double w) { this.to = t; this.w = w; }
    }
    static class Pair {
        String var;
        double val;
        Pair(String v, double val) { this.var = v; this.val = val; }
    }
}
