class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        
        for (int i = 0; i < nums.length; i++) {
            if (i > maxReach) return false; // If we reach an unreachable index, return false
            maxReach = Math.max(maxReach, i + nums[i]); // Update max reachable index
        }
        
        return true; // If we finish loop, reaching last index is possible
    }
}
