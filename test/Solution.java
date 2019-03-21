package test;

public class Solution {
             public int maxWidthRamp(int[] A) {
            	 int N = A.length;
            	 int ans = 0;
            	 int m = 0;
            	 for(int i = 0; i < N-1; i++) {
            		 for(int j = N-1; j > i; j--) {
            			if(A[i]<=A[j]) {
            				m = j-i;
            				ans = Math.max(m, ans);
            				break;
            			} 
            		 }
            	 }
                 return ans;
             }
             public static void main(String[] args) {
            		Solution question = new Solution();
            		int[] A = new int[] {9,8,1,0,1,9,4,0,4,1,};
            		int[] B = new int[] {6,0,8,2,1,5};
            		int ansOne = question.maxWidthRamp(A);
            		int ansTwo = question.maxWidthRamp(B);
            		System.out.println(ansOne);
            		System.out.println(ansTwo);
            	}
}
