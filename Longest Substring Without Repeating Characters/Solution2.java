public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] letter = new int[256];
        int len = s.length();
        int longest = 0;
        resetArray(letter);
        int start = 0;
        for(int i = 0; i < len; ++i) {
        	//System.out.println(s.charAt(i));
        	
        	int c = s.charAt(i);
        	//System.out.println("letter[c[i]] = "+ letter[c]);
        	if(letter[c] == -1 || letter[c] < start)
        		letter[c] = i;
        	else{
        		if(i - start > longest)
        			longest = i - start;
        		start = letter[c]+1; // here error start = i+1; wrong !! start from the first duplicated letter
        		letter[c] = i; // should update the current c otherwise the start would be wrong.
        	}
        }
		if(len - start > longest)// assume the end of string is a wild card
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