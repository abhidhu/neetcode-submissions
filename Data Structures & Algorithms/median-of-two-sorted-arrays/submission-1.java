class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int n1 = nums1.length;
        int n2 = nums2.length;
        int half = (n1 + n2 + 1) / 2;
        
        int left = 0;
        int right = n1;
        
        while (left <= right) {
            int partition1 = left + (right - left) / 2;
            int partition2 = half - partition1;
            
            // Get boundary values (use Integer.MIN/MAX for edges)
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == n1) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n2) ? Integer.MAX_VALUE : nums2[partition2];
            
            // Check if valid partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // Found correct partition
                if ((n1 + n2) % 2 == 0) {
                    // Even total count
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // Odd total count
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Too many elements from nums1, move left
                right = partition1 - 1;
            } else {
                // Too few elements from nums1, move right
                left = partition1 + 1;
            }
        }
        
        return 0.0; // Should never reach here for valid inputs
    }
}