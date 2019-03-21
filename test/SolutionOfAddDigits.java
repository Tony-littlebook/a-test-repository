package test;
import java.util.Scanner;

public class SolutionOfAddDigits {
	
	public int addDigits(int num) {
		int addNum = 0;
		int result = 0;
		int times = 0;
		if(num < 10)
			return 1;
		while(num >= 10) {
		    while(num > 0) {
			addNum = num % 10;
			result += addNum;
			num = ( num - addNum )/10;
		    }
		    ++times;
		    num = result;
		    result = 0;
		}
		return times;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionOfAddDigits myDigits = new SolutionOfAddDigits();
		Scanner s = new Scanner(System.in);
		boolean isContinue = true;
		while(isContinue) {
		    System.out.println("Please input a num£º");
		    int num = s.nextInt();
		    int resultTimes = myDigits.addDigits(num);
		    System.out.println("The answer is " + resultTimes);
		    System.out.println("Continue?(1/2)?");
		    int c = s.nextInt();
		    if(c == 2)
		    	isContinue = false;
		}
		s.close();
    }
}
