class Solution:
    def predictPartyVictory(self, senate: str) -> str:
        senators = list(senate)
        radiant_bans, dire_bans = 0, 0

        while True:
            next_round = []

            for senator in senators:
                if senator == 'R':
                    if radiant_bans > 0:
                        radiant_bans -= 1
                    else:
                        dire_bans += 1
                        next_round.append('R')
                elif senator == 'D':
                    if dire_bans > 0:
                        dire_bans -= 1
                    else:
                        radiant_bans += 1
                        next_round.append('D')

            senators = next_round

            if all(s == 'R' for s in senators):
                return "Radiant"
            elif all(s == 'D' for s in senators):
                return "Dire"
        
