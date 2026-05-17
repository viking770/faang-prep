public class NextPermutation {

    public void reverse(int[] nums, int i){
        int s = i; int e = nums.length-1; 
        while(s<e){
            int temp = nums[e];
            nums[e]= nums[s];
            nums[s] = temp;
            s++;
            e--;
        }

    }
    public void nextPermutation(int[] nums) {
        int i;
        for(i=nums.length-1; i>0; i--){

            if(nums[i]>nums[i-1]){
                int idx = i-1;
                for(int j = i; j<nums.length; j++){
                    if(nums[j]>nums[i-1] && (idx==i-1 || nums[j]<=nums[idx])){
                        idx = j;
                    }
                }
                int temp = nums[idx];
                nums[idx] = nums[i-1];
                nums[i-1] = temp;
                break;
            }
        }

        reverse(nums, i);
    }

    public static void main(String[] args){
        int[] nums = {10,2,3,4,0};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.nextPermutation(nums);
    }
    
}