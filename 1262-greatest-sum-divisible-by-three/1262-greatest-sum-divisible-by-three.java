class Solution {
    public int maxSumDivThree(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int sums = 0;
        for(int num:nums){
            sums+=num;
        }
        int mod = sums%3;
        int[] modarr = new int[n];
        for(int i=0; i<n; i++){
            modarr[i] = nums[i]%3;
        }
        if(mod==1){
            int case1 = sums; //eliminating two mod 2's
            int twocount = 0;
            for(int i=0; i<n; i++){
                if(modarr[i]==2 && twocount<2){
                    case1-=nums[i];
                    twocount+=1;
                }
            }
            if(twocount<2){
                case1 = -1;
            }
            int case2 = 0; //eliminating mod1
            for(int j=0; j<n; j++){
                if(modarr[j]==1){
                    case2 = sums-nums[j];
                    break;
                }
            }
            return Math.max(case1,case2);
        }
        else if(mod==2){
            int case1 = sums; //eliminating two 1's;
            int onecount = 0;
            for(int i=0; i<n; i++){
                if(modarr[i]==1 && onecount<2){
                    case1-=nums[i];
                    onecount+=1;
                }
            }
            if(onecount<2){
                case1 = -1;
            }
            int case2 = 0; //eliminating mod2
            for(int j=0; j<n; j++){
                if(modarr[j]==2){
                    case2 = sums-nums[j];
                    break;
                }
            }
            return Math.max(case1,case2);
        }
        else{
            return sums;
        }
    }
}