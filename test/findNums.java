package test;
import java.util.Map;
import java.util.HashMap;
public class findNums {
    public int[] twoSum(int[] nums,int target) {
    	Map<Integer, Integer> ans = new HashMap<>();
    	int len = nums.length;
    	for(int i = 0; i<len; i++ ) {
    		if(ans.containsKey(target - nums[i]))
    			return new int[] {ans.get(target - nums[i]),i};
    		ans.put(nums[i], i);
    	}
    	return null;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findNums find = new findNums();
        int target = 9;
        int[] sum = new int[] {2,3,8,5,7};
        int[] result = find.twoSum(sum,target);
        //for(int i = 0; i < result.length; i++)
        for(int num : result)
            System.out.println(num);
	}

}
