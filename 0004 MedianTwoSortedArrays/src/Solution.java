class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int length1 = nums1.length;
        int length2 = nums2.length;
        int last = 0;
        int current = 0;
        int index1 = 0;
        int index2 = 0;
        int recurseTo = (length1 + length2) / 2 + 1;
        for (int i = 0; i < recurseTo; i++) {
            last = current;
            if (index1 == length1) {
                current = nums2[index2];
                index2 += 1;
            } else if (index2 == length2) {
                current = nums1[index1];
                index1 += 1;
            } else {
                int at1 = nums1[index1];
                int at2 = nums2[index2];
                if (at1 > at2) {
                    current = at2;
                    index2 += 1;
                } else {
                    current = at1;
                    index1 += 1;
                }
            }
        }
        if ((length1 + length2) % 2 == 0) {
            return (last + current) / 2.0;
        }
        return current;
    }
}
