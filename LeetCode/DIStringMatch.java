class Solution {
    public int[] diStringMatch(String s) {
        int n = s.length();
        int[] temp = new int[n+1];
        for(int i=0; i <= n; i++){
            temp[i] = i;
        }
        int[] result = new int[n+1];
        int x = 0, y = n;
        for(int i=0; i < n; i++){
            if(s.charAt(i) == 'I'){
                result[i] = x;
                x+=1;
            }
            else {
                result[i] = y;
                y-=1;
            }
        }
        result[n] = y;
        return result;
    }
}
