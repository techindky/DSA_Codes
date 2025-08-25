class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) return result;

        // Step 1: Build frequency map for words
        Map<String, Integer> wordFreq = new HashMap<>();
        for (String w : words) {
            wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);
        }

        // Step 2: Check for each possible offset
        for (int i = 0; i < wordLen; i++) {
            int left = i, right = i;
            Map<String, Integer> seen = new HashMap<>();
            int count = 0; // number of words matched

            while (right + wordLen <= s.length()) {
                String w = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(w)) {
                    seen.put(w, seen.getOrDefault(w, 0) + 1);
                    count++;

                    // If seen too many times, shrink from left
                    while (seen.get(w) > wordFreq.get(w)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        left += wordLen;
                        count--;
                    }

                    // Valid window found
                    if (count == wordCount) {
                        result.add(left);
                    }
                } else {
                    // Reset window
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        }
        return result;
    }
}
