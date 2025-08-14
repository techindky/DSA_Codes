class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> result = new HashSet<>();
        for(String email : emails) {
            int index1 = email.indexOf('@');
            int index2 = email.indexOf('+');
            String localName;
            if(index2 > 0){
                localName = email.substring(0,index2);
            }
            else{
                localName = email.substring(0,index1);
            }
            String domainName = email.substring(index1);
            result.add(localName.replace(".","") + domainName);
        }
        return result.size();
    }
}
