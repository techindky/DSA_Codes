class Solution:
    def dividePlayers(self, skill: List[int]) -> int:
        s = sum(skill) // (len(skill) // 2)
        chemistry = 0
        end = len(skill) - 1
        skill.sort()
        for i in range((len(skill)//2)):
            if skill[i] + skill[end] != s:
                return -1
            chemistry += skill[i] * skill[end]
            end -= 1
        return chemistry
