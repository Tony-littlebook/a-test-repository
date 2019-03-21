package test;
import java.util.ArrayList;
public class SimpleDotComGame {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	    int numOfguesses = 0;
	    //int[] location = new int[3];3
	    int randomNum = (int) (Math.random()*5);
	    //int[] location = {randomNum, randomNum + 1, randomNum + 2};
	    ArrayList<String> location = new ArrayList<String>();
	    for(int i = randomNum; i < randomNum + 3; i++)
	        location.add(Integer.toString(i));
	    GameHelper helper = new GameHelper();
	    SimpleDotCom dotCom = new SimpleDotCom();
	    dotCom.setLocationCells(location);
	    boolean isAlive = true;
	    while(isAlive == true) {
	    	String guess = helper.getUserInput("enter a number");
	    	String result = dotCom.checkYourself(guess);
	    	numOfguesses++;
	    	if(result.equals("kill")) {
	    		isAlive = false;
	    		System.out.println("You took " + numOfguesses + " guesses");
	    	}
	    }
	}

}
