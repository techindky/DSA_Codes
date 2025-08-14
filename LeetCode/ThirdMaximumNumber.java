class Solution {
    public int thirdMax(int[] nums) {
        int firstmax = -2147483648;
        int flag = 0;
        int secondmax = -2147483648;
        int thirdmax = -2147483648;
        int n = nums.length;
        for(int i=0;i<n;i++){
            if(nums[i]>=firstmax){
                flag = 1;
                firstmax = nums[i];
            }
        }
        System.out.println(firstmax);
        for(int i=0;i<n;i++){
            if(nums[i]>=secondmax && nums[i]!=firstmax){
                flag = 2;
                secondmax = nums[i];
            }
        }
        System.out.println(secondmax);
        for(int i=0;i<n;i++){
            if(nums[i]>=thirdmax && nums[i]!=firstmax && nums[i]!=secondmax){
                flag = 3;
                thirdmax = nums[i];
            }
        }
        System.out.println(thirdmax);
        if(flag<3){
            return firstmax;
        }
        else{
            return thirdmax;
        }
    }
}
