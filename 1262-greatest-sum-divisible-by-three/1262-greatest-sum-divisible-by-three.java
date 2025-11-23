class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int sums = 0;
        for(int num:nums){
            sums+=num;
        }
        int mod = sums%3;
        for(int i=0; i<nums.length; i++){
            if(nums[i]%3==mod){
                sums=sums-nums[i];
                break;
            }
        }
        return sums;
    }
}