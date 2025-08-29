class Solution {
    public List<String> commonChars(String[] words) {
        int[] minFreq = new int[26];
        Arrays.fill(minFreq, 101);
        for (String word : words) {
            int[] freq = new int[26];
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                freq[c - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                minFreq[i] = Math.min(minFreq[i], freq[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            String val = String.valueOf((char)(i+'a'));
            for (int j = 0; j < minFreq[i]; j++) {
                res.add(val);
            }
        }
        return res;
    }
}
