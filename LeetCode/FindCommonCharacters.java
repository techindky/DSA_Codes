class Solution {
    public List<String> commonChars(String[] words) {
        int n = words.length;
        List<Map<Character, Integer>> freqList = new ArrayList<>();
        for (String word : words) {
            Map<Character, Integer> freq = new HashMap<>();
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                freq.put(c, freq.getOrDefault(c, 0) + 1);
            }
            freqList.add(freq);
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < words[0].length(); i++) {
            char key = words[0].charAt(i);
            int value = freqList.get(0).get(key);
            boolean found = true;
            for (int j = 1; j < n; j++) {
                int v = freqList.get(j).getOrDefault(key, 0);
                if (v == 0) {
                    found = false;
                    break;
                }
                freqList.get(j).put(key, v - 1);
            }
            if (value > 0 && found) {
                freqList.get(0).put(key, value - 1);
                res.add(String.valueOf(key));
            }
        }
        return res;
    }
}
