class Solution {
    public int countSeniors(String[] details) {
        int count = 0;
        for(int i = 0; i < details.length; i++){
            if(Integer.parseInt(details[i].charAt(11)+""+details[i].charAt(12)) > 60){
                count++;
            }
        }
        return count;
    }
}
