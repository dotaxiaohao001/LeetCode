public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] letter = new int[256];
        resetArray(letter);
        int len = s.length();
        int longest = 0;
        int start = 0;
        char[] c = s.toCharArray();
        for(int i = 0; i < len; ++i) {
        	System.out.println(c[i]);
        	System.out.println("letter[c[i]] = "+ letter[c[i]]);
        	if(letter[c[i]] != -1 && letter[c[i]] >= start){ // now c[i] == c[start]
        		if(i - start > longest)
        			longest = i - start;
        		start = letter[c[i]]+1;
        	} // letter[c[i]] == 0 || < start which is checked
        		
        	letter[c[i]] = i;
        
        }
        if(len - start > longest)
        	longest = len - start;
        return longest;
    }

    private void resetArray(int[] A) {
    	int len = A.length;
    	for(int i = 0; i < len; ++i) {
    		A[i] = -1;
    	}
    }

    public static void main(String[] args){
    		Solution s = new Solution();
    		System.out.println(s.lengthOfLongestSubstring("wlrbbmqbhcdarzowkkyhiddqscdxrjmowfrxsjybldbefsarcbynecdyggxxpklorellnmpapqfwkhopkmco"));
    }
}