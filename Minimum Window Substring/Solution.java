public class Solution {
    public String minWindow(String S, String T) {
    	int len1 = S.length();
    	int len2 = T.length();   	
        int[] need = new int[256];
        int[] checked = new int[256];

        for(int i = 0; i < len2; ++i) {
        	char c = T.charAt(i);
        	need[c] += 1;
        }

        int start = 0;
        int end = 0;
        int count = 0;
        String window = "";
        char[] sArray = S.toCharArray();
        for(int i = 0; i < len1;) {
        	// find the substring which contain all letters in T
        	while(i < len1 && count < len2) {
        		checked[sArray[i]] += 1;
        		if(checked[sArray[i]] <= need[sArray[i]])
        			count++;
        		i++;
        	}
        	
        	if(count != len2)
        		break;
        	
        	end = i;// the next positon to the end of string
        	// now count == len2 contract start
        	while(checked[sArray[start]] > need[sArray[start]]) {
        		checked[sArray[start]]--;
        		start++;
        	}
        	if(window == "" || end - start < window.length())
        		window = S.substring(start, end);
        	//find to next window
        	checked[sArray[start]]--;
        	start++;
        	count--;
        }

        return window;
    }
  public static void main(String args[]) {
	  Solution s = new Solution();
	  System.out.println(s.minWindow("a", "b"));
	  System.out.println(s.minWindow("A", "ABC") + "!!");
  }
}
