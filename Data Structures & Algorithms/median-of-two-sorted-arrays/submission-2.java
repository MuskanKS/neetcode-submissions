class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] res = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;

        while(i < m && j < n){
            if(nums1[i] <= nums2[j]){
                res[k] = nums1[i];
                i++;
            }else{
                res[k] = nums2[j];
                j++;
            }
            k++;
        }

        // fill remaining nums1 
        while(i < m){
            res[k] = nums1[i];
            i++;
            k++;
        }

        // fill remaining nums2
        while(j < n){
            res[k] = nums2[j];
            j++;
            k++;
        }
        

        // check for odd and even
        int total = m + n;
        if(total % 2 == 1){
            return res[total / 2];
        }else{
            return (res[total / 2 -1] + res[total / 2]) / 2.0;
        }
    }
}
