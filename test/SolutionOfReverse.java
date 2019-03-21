package test;

public class SolutionOfReverse {
    int reverse(int x) {
    	int addNum = 0;
    	long result = 0;
    	while(x != 0){
        addNum = x % 10;
    	x = ( x - addNum ) / 10;
    	result = 10 * result + addNum;
    	}
    	if((result < (-1) * Math.pow(2, 31)) || (result > (Math.pow(2,31)-1)))
    		return 0;
    	return (int)result;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SolutionOfReverse myReverse = new SolutionOfReverse();
        int x = 4236469;
        int y = -780;
        System.out.println(myReverse.reverse(x));
        System.out.println(myReverse.reverse(y));
	}

}
