class Solution {
    public boolean judgeCircle(String moves) {
        int l = 0,u = 0,d = 0,r = 0;
        for (int i = 0; i < moves.length(); i++) {
            if (moves.charAt(i) == 'U') u++;
            else if (moves.charAt(i) == 'D') d++;
            else if (moves.charAt(i) == 'L') l++;
            else r++;
        }
        return l == r && u == d;
    }
}
