package test;
public class SolutionOfDivide {
	public int divide(int dividend, int divisor) {
		int result = 0;
		int temp = 1;
		int INT_MAX = Integer.MAX_VALUE;
		int INT_MIN = Integer.MIN_VALUE;
		int divid = Math.abs(dividend);
		int divi = Math.abs(divisor);
		if(divisor == 1)
			return dividend;
		if(divisor == -1) {
			if(dividend < INT_MIN)
			    return INT_MAX;
			return -dividend;
		}
		while(divid >= divi ) {
			if(divid >= (divi << 1)) {
			    divi = divi << 1;
			    temp = temp << 1;
			}
			else{
			    result += temp;
			    temp = 1;
				divid = divid - divi;
				divi = Math.abs(divisor);
			}
		}
		//if(result > INT_MAX + 1)
			//return INT_MAX;
			
		if(((dividend ^ divisor) & INT_MIN) == INT_MIN) {
			return -result;
		}
		else 
			return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionOfDivide myDivide = new SolutionOfDivide();
        int x = 83645;
        int y = 15;
        System.out.println(myDivide.divide(x,y));
	}
}
