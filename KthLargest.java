* Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
package test;

public class KthLargest {
	int[] A;
    int index;
    public KthLargest(int k, int[] nums) {
        if(nums != null){
            quickSort(nums, 0, nums.length - 1);
            A = nums;
        }
        index = k;
    }
    
    public int add(int val) {
        if(A == null){
            A = new int[1];
            A[0] = val;
            return A[index-1];
        }
        else{
            int[] temp = new int[A.length + 1];
            int s = 0;
            while(s < A.length && val < A[s])
                s++;
            temp[s] = val;
            for(int i = 0;i < s; ++i)
                temp[i] = A[i];
            for(int i = s + 1;i < temp.length; ++i)
                temp[i] = A[i-1];
            A = temp;
            return A[index-1];
        }
        
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
            while(low < high && nums[high] <= x)
                high--;
            if(low < high){
                nums[low] = nums[high];
                low++;
            }
            while(low < high && nums[low] > x)
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
		int k = 1;
		int[] arr = {};
		KthLargest kthLargest = new KthLargest(k, arr);
		System.out.println(kthLargest.add(-3));
		System.out.println(kthLargest.add(-2));
		System.out.println(kthLargest.add(-4));
		System.out.println(kthLargest.add(0));
		System.out.println(kthLargest.add(4));

	}

}
