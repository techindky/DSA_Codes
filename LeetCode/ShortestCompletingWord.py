class Solution:
    def shortestCompletingWord(self, licensePlate: str, words: List[str]) -> str:
        letters = ""
        result = []
        for i in licensePlate:
            if i.isalpha():
                letters+=i.lower()
        str1 = Counter(letters)
        for word in words:
            str2 = Counter(word)
            if all(str1[letter] <= str2[letter] for letter in str1):
                result.append(word)
        shortestLength = 15
        string = ""
        for i in result:
            if len(i) < shortestLength:
                shortestLength = len(i)
                string = i
        return string
