class Solution:
    def uniqueMorseRepresentations(self, words: List[str]) -> int:
        d = {"a":".-","b":"-...","c":"-.-.","d":"-..","e":".","f":"..-.","g":"--.","h":"....","i":"..","j":".---","k":"-.-","l":".-..","m":"--","n":"-.","o":"---","p":".--.","q":"--.-","r":".-.","s":"...","t":"-","u":"..-","v":"...-","w":".--","x":"-..-","y":"-.--","z":"--.."}
        result = []
        for word in words:
            temp = ""
            for char in word:
                temp+=d[char]
            result.append(temp)
        return len(set(result))
