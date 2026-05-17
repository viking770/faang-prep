import java.util.*;
public class NextPermutation {

    void findNextPermutation(int[] nums) {
            int pivot = findBreakingPoint(nums) - 1;
            if (pivot != -1) {
            int nextPrefix = rightMostSuccessor(nums, nums[pivot]); 
            swap(nums, pivot, nextPrefix);
        }
        reverseSuffix(nums, pivot + 1);
        System.out.println(Arrays.toString(nums));
    }

    int rightMostSuccessor(int[] nums, int threshold) {
        for (int i = nums.length - 1; i >= 0; i--) {
            if (threshold < nums[i]) return i;
        }
        return -1;
    }

    int findBreakingPoint(int[] nums) {
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) return i;
        }
        return 0;
    }

    void reverseSuffix(int[] nums, int start) {
        int end = nums.length - 1;
        while (start < end) {
            swap(nums, start++, end--);
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args){
        int[] nums = {10,2,3,4,0};
        NextPermutation nextPermutation = new NextPermutation();
        nextPermutation.findNextPermutation(nums);
    }
    
}
