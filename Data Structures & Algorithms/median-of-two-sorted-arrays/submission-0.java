class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int[] res = new int[nums1.length + nums2.length];

        int i = 0;
        int j = 0;
        int k = 0;

        // Compare and put smaller element into res
        while (i < nums1.length && j < nums2.length) {

            if (nums1[i] <= nums2[j]) {
                res[k] = nums1[i];
                i++;
            } else {
                res[k] = nums2[j];
                j++;
            }

            k++;
        }

        // If nums1 still has elements
        while (i < nums1.length) {
            res[k] = nums1[i];
            i++;
            k++;
        }

        // If nums2 still has elements
        while (j < nums2.length) {
            res[k] = nums2[j];
            j++;
            k++;
        }

        // Find median
        if (res.length % 2 == 1) {
            return res[res.length / 2];
        } else {
            return (res[res.length / 2 - 1] 
                    + res[res.length / 2]) / 2.0;
        }
    }
}