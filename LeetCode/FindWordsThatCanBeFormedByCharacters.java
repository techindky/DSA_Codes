class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] charFreq = new int[26];
        int res = 0;
        for (int i = 0; i < chars.length(); i++) {
            charFreq[chars.charAt(i) - 'a']++;
        }
        for (String word : words) {
            int[] a = new int[26];
            boolean isGood = true;
            for (int i = 0; i < word.length(); i++) {
                int c = word.charAt(i) - 'a';
                if (charFreq[c] < ++freq[c]) {
                    isGood = false;
                    break;
                }
            }
            if (isGood) res += word.length();
        }
        return res;
    }
}
