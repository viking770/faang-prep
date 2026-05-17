import java.util.*;

public class TwoSums {

    public static int[] twoSumWorst(int[] nums, int target) {
        // Outer loop iterates through each element
        for (int i = 0; i < nums.length; i++) {
            // Inner loop checks every subsequent element
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j };
                }
            }
        }
        // Return an empty array if no solution is found
        return new int[] {};
    }

    public int[] twoSumBest(int[] nums, int target) {
            // Map to store: [Value -> Index]
            Map<Integer, Integer> map = new HashMap<>();
            
            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                
                // Check if the number we need has already been seen
                if (map.containsKey(complement)) {
                    return new int[] { map.get(complement), i };
                }
                
                // Otherwise, remember this number and its index
                map.put(nums[i], i);
            }
            
            return new int[] {};
        }
    
}
