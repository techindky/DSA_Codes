class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        int i = 0;
        int n = nums1.length;
        int m = nums2.length;
        Set<Integer> result = new HashSet<>();
        for(i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(nums1[i]==nums2[j]){
                    result.add(nums1[i]);
                    break;
                }
            }
        }
        i = 0;
        int[] result1 = new int[result.size()];
        for (Integer num : result) {
            result1[i++] = num;
        }
        return result1;
    }
}
