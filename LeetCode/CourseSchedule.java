import java.util.*;

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> g = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) g.add(new ArrayList<>());
        int[] indeg = new int[numCourses];

        for (int[] p : prerequisites) {
            int a = p[0], b = p[1];
            g.get(b).add(a);
            indeg[a]++;
        }

        Deque<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (indeg[i] == 0) q.add(i);

        int seen = 0;
        while (!q.isEmpty()) {
            int u = q.poll();
            seen++;
            for (int v : g.get(u)) {
                if (--indeg[v] == 0) q.add(v);
            }
        }
        return seen == numCourses;
    }
}
