package test;

public class SolutionOfmaxSubArray {
	public int maxSubArray1(int[] nums) {
		int k = nums.length;
        if(k == 1) return nums[0];
        int minPrice = nums[0];
        int max = nums[0];
        int sum = nums[0];
        for(int i = 1; i < k; ++i){
            sum += nums[i];
            int s = Math.max(sum, sum - minPrice);
            if(max < s)
                max = s;
            if(minPrice > sum)
                minPrice = sum;
            System.out.println(max);
        }
        return max;
    }
	
public int maxSubArray2(int[] nums) {
		int max = nums[0];
        int sum = 0;
        for(int num : nums){
            sum += num;
            max = Math.max(max, sum);
            if(sum <= 0)
                sum = 0;
        }
        return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SolutionOfmaxSubArray maxArray = new SolutionOfmaxSubArray();
        int[] nums= new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxArray.maxSubArray2(nums));
	}

}
