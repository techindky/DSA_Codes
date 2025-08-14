class Solution:
    def stringMatching(self, words: List[str]) -> List[str]:
        result = set()
        for i in range(len(words)):
            for j in range(len(words)):
                if i==j or words[j] in result:
                    continue
                if words[j] in words[i]:
                    result.add(words[j])
        return list(result)
