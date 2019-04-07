/*求两数组的交集，结果不包含重复元素，
利用“桶”实现最快遍历5次*/
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[0];
        }
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i] > max) {
                max = nums1[i];
            }
        }
        for (int i = 0; i < nums2.length; i++) {
            if (nums2[i] > max) {
                max = nums2[i];
            }
        }
        int count = 0;
        int[] book = new int[max + 1];
        for (int i = 0; i < nums1.length; i++) {
            if (book[nums1[i]] == 0)
                book[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (book[nums2[i]] == 1) {
                book[nums2[i]]++;
                count++;
            }
        }
        int[] testan = new int[count];
        for (int i = 0,j=0; i < book.length; i++) {
            if (book[i] > 1) {
                testan[j++] = i;
            }
        }
        return  testan;
    }
}
