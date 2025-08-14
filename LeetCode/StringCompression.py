class Solution:
    def compress(self, chars: List[str]) -> int:
        s = [[chars[0],1]]
        j = 0
        for i in range(1,len(chars)):
            if chars[i]==s[j][0]:
                s[j][1]+=1
            else:
                s.append([chars[i],1])
                j+=1
        #print(s)
        chars.clear()
        for i in s:
            if i[1]==1:
                chars.append(i[0])
            elif i[1]>=10:
                chars.append(i[0])
                for j in str(i[1]):
                    chars.append(j)
            else:
                chars.append(i[0])
                chars.append(str(i[1]))
        return len(chars)
