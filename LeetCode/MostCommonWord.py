class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        paragraph = paragraph.replace("!", " ")
        paragraph = paragraph.replace("?", " ")
        paragraph = paragraph.replace("'", " ")
        paragraph = paragraph.replace(",", " ")
        paragraph = paragraph.replace(";", " ")
        paragraph = paragraph.replace(".", " ")
        words = (paragraph.lower()).split()
        d = {}
        print(words)
        for word in words:
            d[word] = d.get(word, 0) + 1
        for i in banned:
            if i in d:
                d.pop(i)
        result = ["",0]
        for key,value in d.items():
            if value > result[1]:
                result[0] = key
                result[1] = value
        return result[0]
        
