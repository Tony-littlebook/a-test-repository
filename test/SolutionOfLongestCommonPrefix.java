package test;

public class SolutionOfLongestCommonPrefix {
	public String longestCommonPrefix(String[] strs) {
		String ans = "";
        if(strs.length == 0)
          return ans;
        if(strs.length == 1)
          return strs[0];
        int numMin = strs[0].length();
        for(int i = 1; i < strs.length; i++){
          numMin = Math.min(numMin,strs[i].length());
        }
        for(int i = 0; i < numMin; i++) {
        	boolean s = true;
        	for(int j = 0; j < strs.length; j++) {
        		if(strs[0].charAt(i) != strs[j].charAt(i)) {
        			s = false;
        			break;
        		}
        	}
          if(!s)
            break;
          ans += strs[0].charAt(i);          
        }
        return ans;
        
    }
        
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SolutionOfLongestCommonPrefix my = new SolutionOfLongestCommonPrefix();
        String[] strs = new String[]{"caa","","a","acb"};
		System.out.println(my.longestCommonPrefix(strs));
	}
}
