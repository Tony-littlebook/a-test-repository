package test;

public class SolutionOfCanCompleteCircuit {
	 public int canCompleteCircuit(int[] gas, int[] cost) {
	        if(gas.length == 0) return -1;
	        int gasSum = gas[0];
	        int costSum = cost[0];
	        int i = 0;
	        int j = 0;
	        int k = 0;
	        while(j < gas.length){
	            if(gasSum < costSum) {
	                i++;
	                j = 0;
	                //System.out.println(i);
	                if(i <= k || i > gas.length - 1)
	                    break;
	                k = i;
	                gasSum = gas[i];
	                costSum = cost[i];
	                continue;
	            }
	            System.out.println(i);
	            j++;
	            i = (i + 1)%(gas.length);
	            gasSum += gas[i];
	            costSum += cost[i];
	        }
	        if(j == gas.length)
	            return k;
	        else
	            return -1;
	        
	        
	    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] gas = new int[]{4,5,2,6,5,3};
		int[] cost = new int[]{3,2,7,3,2,9};
		SolutionOfCanCompleteCircuit a = new SolutionOfCanCompleteCircuit();
		a.canCompleteCircuit(gas, cost);

	}

}
