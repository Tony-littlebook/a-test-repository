package test;

public class SolutionOfCountAndSay {
    public String countAndSay(int n) {
        String initNum = "1";
        if(n == 1)
        	return initNum;
    	for(int i = 1; i < n; i++) {
    		char c = initNum.charAt(0);
    		int count = 0;
    		StringBuilder temp = new StringBuilder();
        	for(int s = 0;s < initNum.length(); s++) {
        		if(c == initNum.charAt(s)) 
        			count++;
        		else {
        			temp.append(String.valueOf(count) + c);
        			c = initNum.charAt(s);
        			count =1;
        		}
        	}
        	temp.append(String.valueOf(count) + c);
        	initNum = temp.toString();
        	System.out.println(initNum);
        }
    	return initNum;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionOfCountAndSay myTest = new SolutionOfCountAndSay();
		System.out.println(myTest.countAndSay(10));
	}

}
