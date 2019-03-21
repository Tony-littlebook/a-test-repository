package test;

public class SolutionOfIsPalindrome {
    public boolean isPalindrome(int x) {
    	if(x < 0)
    		return false;
    	int result = 0;
    	int num = x;
    	while(x != 0){
    		result = result * 10 + x % 10;
    		x = ( x - x % 10 ) / 10;
    	}
    	if(result == num)
    		return true;
    	else
    		return false;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        SolutionOfIsPalindrome myPalindrome = new SolutionOfIsPalindrome();
        int x = 0;
        int y = 1234321;
        System.out.println(myPalindrome.isPalindrome(x));
        System.out.println(myPalindrome.isPalindrome(y));
	}

}
