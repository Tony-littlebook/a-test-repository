package test;
import java.util.ArrayList;
import java.util.List;
public class SolutionOfIntersection {
	public int[] intersection(int[] nums1, int[] nums2) {       
        if(nums1.length == 0 || nums2.length == 0)
            return new int[]{};
        quickSort(nums1, 0, nums1.length - 1);
        quickSort(nums2, 0, nums2.length - 1);
        if(nums1[0] > nums2[nums2.length - 1] || nums2[0] > nums1[nums1.length - 1])
            return new int[]{};
        int[] temp;
        if(nums2.length < nums1.length){
            temp = nums2;
            nums2 = nums1;
            nums1 = temp;
        }
        List<Integer> list = new ArrayList<>();
        int k1 = nums1.length;
        int k2 = nums2.length;
        int j = 0;
        for(int i = 0; i < k1; ++i){
            if(i > 0 && nums1[i] == nums1[i -1])
                continue;
            while(j < k2 && nums1[i] > nums2[j] ){
                j++;
            }
            if(j >= k2)
                break;
            if(nums1[i] == nums2[j])
                list.add(nums1[i]);
        }
        int[] ans = new int[list.size()];
        for(int i = 0; i < list.size(); ++i)
            ans[i] = list.get(i);
        return ans;
        
    }
    private void quickSort(int[] nums, int p, int r){
        if(p < r){
            int q = partition(nums, p, r);
            quickSort(nums, p, q - 1);
            quickSort(nums, q + 1, r);
        }
    }
    private int partition(int[] nums, int p, int r){
        int x = nums[p];
        int low = p;
        int high = r;
        while(low < high){
            while(low < high && nums[high] > x)
                high--;
            if(low < high){
                nums[low] = nums[high];
                low++;
            }
            while(low < high && nums[low] <= x)
                low++;
            if(low < high){
                nums[high] = nums[low];
                high--;
            }
        }
        nums[high] = x;
        return high;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionOfIntersection intersection = new SolutionOfIntersection();
        int[] nums1 = new int[] {};
        int [] nums2 = new int[] {1};
        int[] nums = intersection.intersection(nums1, nums2);
        //System.out.println(nums1 == null);
        //if(nums == null)
        	//return;
        for(int i = 0; i < nums.length; ++i) {
        	System.out.print(nums[i]);
        	System.out.print(" ");
        }
	}

}
