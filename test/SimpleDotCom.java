package test;
import java.util.ArrayList;
public class SimpleDotCom {
    ArrayList<String> locationCells = new ArrayList<String>();
    //int [] mark = {0,0,0};
    //int numOfHits = 0;
    public void setLocationCells(ArrayList<String> locs) {
    	locationCells = locs;
    }
    public String checkYourself(String stringGuess) {
        //int guess = Integer.parseInt(stringGuess);
    	String result = "miss";
    	/*for(int i = 0; i < 3; i++) {
    		if(guess == locationCells[i]) {
    			if(mark[i] == 0) {
    				mark[i] = 1;
    				result = "hit";
        			numOfHits++;
    			}
    			else {
    				result = "repeated hit";
    			}
    			break;
    		}
    	}*/
    	/*if(locationCells.contains(stringGuess)) {
    		locationCells.remove(stringGuess);
    		result = "hit";
    	}
    	if(numOfHits == locationCells.length) {
    		result = "kill";
    	}*/
    	int index = locationCells.indexOf(stringGuess);
    	/*if(locationCells.isEmpty()) {
    		result = "kill";
    	}*/
    	if(index >= 0) {
    		locationCells.remove(index);
    		if(locationCells.isEmpty()) {
    			result = "kill";
    		}
    		else {
    			result = "hit";
    		}
    	}
    	System.out.println(result);
    	return result;
    }
}
