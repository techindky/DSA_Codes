class Solution {
    public int minimumTeachings(int n, int[][] languages, int[][] friendships) {
        List<Set<Integer>> userLang = new ArrayList<>();
        for (int[] l : languages) userLang.add(new HashSet<>(Arrays.stream(l).boxed().toList()));

        Set<Integer> bad = new HashSet<>();
        for (int[] f : friendships)
            if (Collections.disjoint(userLang.get(f[0] - 1), userLang.get(f[1] - 1))) {
                bad.add(f[0] - 1);
                bad.add(f[1] - 1);
            }

        if (bad.isEmpty()) return 0;

        int[] cnt = new int[n + 1];
        for (int u : bad) for (int lang : userLang.get(u)) cnt[lang]++;
        return bad.size() - Arrays.stream(cnt).max().getAsInt();
    }
}
