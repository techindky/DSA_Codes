class Solution:
    def minimumPushes(self, word: str) -> int:
        pushes = 0
        m = {}
        for i in word:
            m[i] = m.get(i, 0) + 1
        freq = list(m.values())
        freq.sort(reverse=True)
        if(len(freq)<9):
            return len(word)
        else:
            for i in range(len(freq)):
                pushes += freq[i]*(i//8+1)
            return pushes
